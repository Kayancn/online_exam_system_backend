package com.example.online_exam_system_backend.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.online_exam_system_backend.common.Constants;
import com.example.online_exam_system_backend.common.Result;
import com.example.online_exam_system_backend.controller.dto.LoggerDTO;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.online_exam_system_backend.service.ITeacherService;
import com.example.online_exam_system_backend.entity.Teacher;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 教师表 前端控制器
 * </p>
 *
 * @author Kayan
 * @since 2022-05-06
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private ITeacherService teacherService;

    // 登陆
    @PostMapping("/login")
    public Result save(@RequestBody LoggerDTO loggerDTO) {
        String id = loggerDTO.getId();
        String password = loggerDTO.getPassword();
        if (StrUtil.isBlank(id) || StrUtil.isBlank(password)) {
            return Result.error(Constants.CODE_400,"参数错误");
        }
        LoggerDTO dto = teacherService.login(loggerDTO);
        return Result.success(dto);
    }

}

