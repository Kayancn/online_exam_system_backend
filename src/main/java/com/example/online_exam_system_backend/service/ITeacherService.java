package com.example.online_exam_system_backend.service;

import com.example.online_exam_system_backend.controller.dto.LoggerDTO;
import com.example.online_exam_system_backend.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 教师表 服务类
 * </p>
 *
 * @author Kayan
 * @since 2022-05-06
 */
public interface ITeacherService extends IService<Teacher> {

    LoggerDTO login(LoggerDTO loggerDTO);
}
