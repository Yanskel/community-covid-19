package com.brice.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brice.common.R;
import com.brice.dto.HealthInfoDto;
import com.brice.entity.ApartmentComplex;
import com.brice.entity.HealthInfo;
import com.brice.entity.User;
import com.brice.service.ApartmentComplexService;
import com.brice.service.HealthInfoService;
import com.brice.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/healthInfo")
public class HealthInfoController {
    @Autowired
    private HealthInfoService healthInfoService;
    @Autowired
    private UserService userService;
    @Autowired
    private ApartmentComplexService apartmentComplexService;

    /**
     * 健康填报
     *
     * @param healthInfo 健康信息 session
     * @return 填报成功
     */
    @PostMapping
    public R<String> add(@RequestBody HealthInfo healthInfo, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        healthInfo.setResidentId(user.getId());
        healthInfo.setResidentName(user.getName());
        healthInfo.setSubmitTime(LocalDateTime.now());
        healthInfoService.save(healthInfo);
        return R.success("填报成功！");
    }

    /**
     * 动态分页查询
     *
     * @param page     当前页码
     * @param pageSize 每页数据量
     * @param userId   用户id
     * @param name     模糊姓名
     * @return 分页数据
     */
    @GetMapping("/page")
    public R<Page<HealthInfoDto>> getAll(int page, int pageSize, Long userId, String name) {
        Page<HealthInfo> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<HealthInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(name != null, HealthInfo::getResidentName, name);
        queryWrapper.eq(userId != null, HealthInfo::getResidentId, userId);
        queryWrapper.orderByDesc(HealthInfo::getSubmitTime);
        healthInfoService.page(pageInfo, queryWrapper);

        Page<HealthInfoDto> healthInfoDtoPage = new Page<>();
        BeanUtils.copyProperties(pageInfo, healthInfoDtoPage, "records");

        List<HealthInfo> records = pageInfo.getRecords();

        List<HealthInfoDto> list = records.stream().map(item -> {
            HealthInfoDto healthInfoDto = new HealthInfoDto();
            BeanUtils.copyProperties(item, healthInfoDto);

            User user = userService.getById(item.getResidentId());

            ApartmentComplex apartmentComplex = apartmentComplexService.getById(user.getAcId());

            healthInfoDto.setResidentPhone(user.getPhone());
            healthInfoDto.setAcName(apartmentComplex.getAcName());

            return healthInfoDto;
        }).collect(Collectors.toList());

        healthInfoDtoPage.setRecords(list);

        return R.success(healthInfoDtoPage);
    }

    /**
     * 查询是否已经健康填报
     *
     * @param request session
     * @return 健康数据集合
     */
    @GetMapping
    public R<List<HealthInfo>> getList(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        LambdaQueryWrapper<HealthInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(HealthInfo::getResidentId, user.getId());
        queryWrapper.orderByDesc(HealthInfo::getSubmitTime);
        List<HealthInfo> list = healthInfoService.list(queryWrapper);
        return R.success(list);
    }
}
