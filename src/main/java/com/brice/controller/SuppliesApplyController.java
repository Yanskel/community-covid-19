package com.brice.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brice.common.R;
import com.brice.dto.SuppliesApplyDto;
import com.brice.entity.ApartmentComplex;
import com.brice.entity.Supplies;
import com.brice.entity.SuppliesApply;
import com.brice.entity.User;
import com.brice.service.ApartmentComplexService;
import com.brice.service.SuppliesApplyService;
import com.brice.service.SuppliesService;
import com.brice.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/suppliesApply")
public class SuppliesApplyController {
    @Autowired
    private SuppliesApplyService suppliesApplyService;
    @Autowired
    private ApartmentComplexService apartmentComplexService;
    @Autowired
    private SuppliesService suppliesService;
    @Autowired
    private UserService userService;

    /**
     * 动态获取分页申请记录
     *
     * @return 所有申请记录
     */
    @GetMapping("/page")
    public R<Page<SuppliesApplyDto>> getAll(int page, int pageSize, Long userId, int status) {
        Page<SuppliesApply> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<SuppliesApply> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(userId != null, SuppliesApply::getResidentId, userId).eq(status != -1, SuppliesApply::getStatus, status);
        queryWrapper.orderByDesc(SuppliesApply::getApplyTime);
        suppliesApplyService.page(pageInfo, queryWrapper);

        Page<SuppliesApplyDto> suppliesApplyDtoPage = new Page<>();
        BeanUtils.copyProperties(pageInfo, suppliesApplyDtoPage, "records");

        List<SuppliesApply> records = pageInfo.getRecords();
        List<SuppliesApplyDto> list = records.stream()
                .map(this::getSuppliesApplyDto)
                .collect(Collectors.toList());

        suppliesApplyDtoPage.setRecords(list);
        return R.success(suppliesApplyDtoPage);
    }

    /**
     * 根据id查询物资申请记录
     *
     * @param id 申请记录id
     * @return 单条物资申请记录
     */
    @GetMapping("/{id}")
    public R<SuppliesApply> getById(@PathVariable Long id) {
        SuppliesApply suppliesApply = suppliesApplyService.getById(id);
        return R.success(suppliesApply);
    }

    /**
     * 审批物资
     *
     * @param suppliesApply 审批后的信息
     * @return 审批成功
     */
    @PutMapping
    public R<String> update(@RequestBody SuppliesApply suppliesApply) {
        //如果通过
        if (suppliesApply.getStatus() == 1) {
            //物资总数-申请物资的数量
            Supplies supplies = suppliesService.getById(suppliesApply.getSuppliesId());
            //物资总数
            Integer sum = supplies.getTotal();
            if (sum - suppliesApply.getNumber() < 0) {
                return R.error("数量不足");
            }
            supplies.setTotal(sum - suppliesApply.getNumber());
            suppliesService.updateById(supplies);
        }
        suppliesApplyService.updateById(suppliesApply);
        return R.success("审批成功");
    }

    /**
     * 物资申请
     *
     * @param suppliesApply 物资实体
     * @param request       session
     * @return 申请提交成功与否
     */
    @PostMapping
    public R<String> add(@RequestBody SuppliesApply suppliesApply, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        suppliesApply.setResidentId(user.getId());
        suppliesApply.setApplyTime(LocalDateTime.now());
        suppliesApplyService.save(suppliesApply);
        return R.success("提交成功");
    }

    /**
     * 封装方法
     *
     * @param item 物资申请
     * @return 物资申请Dto
     */
    @NotNull
    private SuppliesApplyDto getSuppliesApplyDto(SuppliesApply item) {
        SuppliesApplyDto suppliesApplyDto = new SuppliesApplyDto();
        BeanUtils.copyProperties(item, suppliesApplyDto);

//        suppliesApplyDto.setId(item.getId());
//        suppliesApplyDto.setNumber(item.getNumber());
//        suppliesApplyDto.setApplyTime(item.getApplyTime());
//        suppliesApplyDto.setStatus(item.getStatus());
//        suppliesApplyDto.setReply(item.getReply());

        User user = userService.getById(item.getResidentId());
        suppliesApplyDto.setResidentName(user.getName());
        suppliesApplyDto.setAddress(user.getAddress());
        suppliesApplyDto.setResidentPhone(user.getPhone());

        ApartmentComplex apartmentComplex = apartmentComplexService.getById(user.getAcId());
        suppliesApplyDto.setAcName(apartmentComplex.getAcName());

        Supplies supplies = suppliesService.getById(item.getSuppliesId());
        suppliesApplyDto.setSuppliesName(supplies.getName());
        return suppliesApplyDto;
    }
}
