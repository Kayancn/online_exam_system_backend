package com.example.online_exam_system_backend.service.impl;

import com.example.online_exam_system_backend.entity.Course;
import com.example.online_exam_system_backend.mapper.CourseMapper;
import com.example.online_exam_system_backend.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程表 服务实现类
 * </p>
 *
 * @author Kayan
 * @since 2022-05-09
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

}
