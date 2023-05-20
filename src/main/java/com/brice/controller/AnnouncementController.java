package com.brice.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.brice.common.R;
import com.brice.entity.Announcement;
import com.brice.service.AnnouncementService;

/**
 * 公告Controller
 *
 * @author Brice
 * @date 2023/05/20
 */
@RestController
@RequestMapping("/api/announcement")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    /**
     * 从新到旧查询所有公告
     *
     * @return 排序后的所有公告
     */
    @GetMapping
    public R<List<Announcement>> getAll() {
        LambdaQueryWrapper<Announcement> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Announcement::getAnnounceTime);
        List<Announcement> list = announcementService.list(queryWrapper);
        return R.success(list);
    }

    /**
     * 新增公告
     *
     * @param announcement 公告
     * @return 新增成功
     */
    @PostMapping
    public R<String> add(@RequestBody Announcement announcement) {
        announcement.setAnnounceTime(LocalDateTime.now());
        announcementService.save(announcement);
        return R.success("提交成功");
    }
}
