package com.example.online_exam_system_backend.config.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.online_exam_system_backend.common.Constants;
import com.example.online_exam_system_backend.entity.Student;
import com.example.online_exam_system_backend.entity.Teacher;
import com.example.online_exam_system_backend.exception.ServiceException;
import com.example.online_exam_system_backend.service.IStudentService;
import com.example.online_exam_system_backend.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IStudentService studentService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过,没请求到具体方法
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        // 执行认证
        if (StrUtil.isBlank(token)) {
            throw new ServiceException(Constants.CODE_401, "无token，请重新登录");
        }
        // 获取 token 中的 logger id
        String loggerId;
        try {
            loggerId= JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new ServiceException(Constants.CODE_401, "token验证失败，请重新登录");
        }

        // 根据token中的loggerId查询数据库
        Student student = studentService.getById(loggerId);
        Teacher teacher = teacherService.getById(loggerId);
        if (teacher == null && student == null) {
            throw new ServiceException(Constants.CODE_401, "用户不存在，请重新登录");
        } else if (teacher != null) {
            // 用户密码加签 验证 token
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(teacher.getPassword())).build();
            try {
                jwtVerifier.verify(token); // 验证token
            } catch (JWTVerificationException e) {
                throw new ServiceException(Constants.CODE_401, "token验证失败，请重新登录");
            }
        } else {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(student.getPassword())).build();
            try {
                jwtVerifier.verify(token); // 验证token
            } catch (JWTVerificationException e) {
                throw new ServiceException(Constants.CODE_401, "token验证失败，请重新登录");
            }
        }
        return true;
    }
}
