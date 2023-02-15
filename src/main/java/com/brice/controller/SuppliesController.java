package com.brice.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.brice.common.R;
import com.brice.dto.SuppliesDto;
import com.brice.entity.Category;
import com.brice.entity.Supplies;
import com.brice.service.CategoryService;
import com.brice.service.SuppliesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/supplies")
public class SuppliesController {
    @Autowired
    private SuppliesService suppliesService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有物资
     *
     * @return 返回处理后的物资数据
     */
    @GetMapping
    public R<List<SuppliesDto>> getAll() {
        //获取所有物资
        List<Supplies> list = suppliesService.list();
        List<SuppliesDto> dtoList = list.stream().map(supplies -> {
            SuppliesDto suppliesDto = new SuppliesDto();
            BeanUtils.copyProperties(supplies,suppliesDto);

//            suppliesDto.setId(supplies.getId());
//            suppliesDto.setName(supplies.getName());
//            suppliesDto.setTotal(supplies.getTotal());
//            suppliesDto.setCategoryId(supplies.getCategoryId());

            LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
            categoryLambdaQueryWrapper.eq(Category::getId, supplies.getCategoryId());
            //查询相应物资分类
            Category category = categoryService.getOne(categoryLambdaQueryWrapper);
            suppliesDto.setCategoryName(category.getType());
            return suppliesDto;
        }).collect(Collectors.toList());

        return R.success(dtoList);
    }

    /**
     * 新增物资
     *
     * @param supplies 物资数据
     * @return 成功与否
     */
    @PostMapping
    public R<String> add(@RequestBody Supplies supplies) {
        suppliesService.save(supplies);
        return R.success("添加成功");
    }

    /**
     * 删除物资
     *
     * @param id 物资id
     * @return 返回删除信息
     */
    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable Long id) {
        suppliesService.removeById(id);
        return R.success("删除成功!");
    }

    /**
     * 修改物资信息
     *
     * @param supplies 物资数据
     * @return 修改成功与否
     */
    @PutMapping
    public R<String> update(@RequestBody Supplies supplies) {
        suppliesService.updateById(supplies);
        return R.success("修改成功");
    }

    /**
     * 根据id查询物资
     *
     * @param id 物资id
     * @return 单条物资数据
     */
    @GetMapping("/{id}")
    public R<Supplies> getById(@PathVariable Long id) {
        Supplies supplies = suppliesService.getById(id);
        return R.success(supplies);
    }
}
