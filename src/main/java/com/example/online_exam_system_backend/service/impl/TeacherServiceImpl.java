package com.example.online_exam_system_backend.service.impl;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.online_exam_system_backend.controller.dto.LoggerDTO;
import com.example.online_exam_system_backend.entity.Teacher;
import com.example.online_exam_system_backend.mapper.TeacherMapper;
import com.example.online_exam_system_backend.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 教师表 服务实现类
 * </p>
 *
 * @author Kayan
 * @since 2022-05-06
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {
    private static final Log LOG = Log.get();
    @Override
    public boolean login(LoggerDTO loggerDTO) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", loggerDTO.getId());
        queryWrapper.eq("password", loggerDTO.getPassword());
        // 处理异常情况
        try {
            Teacher one = getOne(queryWrapper);
            return one != null;
        } catch (Exception e) {
            LOG.error(e);
            return false;
        }
    }
}
