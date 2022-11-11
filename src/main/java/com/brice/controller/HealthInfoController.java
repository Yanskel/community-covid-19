package com.brice.controller;

import com.brice.common.R;
import com.brice.entity.HealthInfo;
import com.brice.entity.User;
import com.brice.service.HealthInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/healthInfo")
public class HealthInfoController {
    @Autowired
    private HealthInfoService healthInfoService;

    /**
     * 健康填报
     *
     * @param healthInfo 健康信息 session
     * @return 填报成功
     */
    @PostMapping
    public R<String> add(@RequestBody HealthInfo healthInfo, HttpServletRequest request){
        Long userId = (Long) request.getSession().getAttribute("user");
        healthInfo.setResidentId(userId);
        healthInfo.setSubmitTime(LocalDateTime.now());
        healthInfoService.save(healthInfo);
        return R.success("填报成功！");
    }
}
