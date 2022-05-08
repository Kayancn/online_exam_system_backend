package com.example.online_exam_system_backend.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.online_exam_system_backend.common.Constants;
import com.example.online_exam_system_backend.controller.dto.LoggerDTO;
import com.example.online_exam_system_backend.entity.Teacher;
import com.example.online_exam_system_backend.exception.ServiceException;
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
    public LoggerDTO login(LoggerDTO loggerDTO) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", loggerDTO.getId());
        queryWrapper.eq("password", loggerDTO.getPassword());
        Teacher one;
        // 处理异常情况
        try {
            one = getOne(queryWrapper);//从数据库查询教师信息
        } catch (Exception e) {
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
        if(one != null){
            BeanUtil.copyProperties(one, loggerDTO, true);
            return loggerDTO;
        } else {
            throw new ServiceException(Constants.CODE_600,"账号或密码错误");
        }
    }
}
