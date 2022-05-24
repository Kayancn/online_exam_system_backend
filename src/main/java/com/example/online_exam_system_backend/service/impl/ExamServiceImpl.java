package com.example.online_exam_system_backend.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.online_exam_system_backend.common.Constants;
import com.example.online_exam_system_backend.controller.dto.ExamDTO;
import com.example.online_exam_system_backend.entity.Exam;
import com.example.online_exam_system_backend.entity.Teacher;
import com.example.online_exam_system_backend.exception.ServiceException;
import com.example.online_exam_system_backend.mapper.ExamMapper;
import com.example.online_exam_system_backend.service.IExamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.online_exam_system_backend.utils.TokenUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 考试表 服务实现类
 * </p>
 *
 * @author Kayan
 * @since 2022-05-09
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements IExamService {
    private static final Log LOG = Log.get();

    @Override
    public ExamDTO begin(ExamDTO examDTO) {
        QueryWrapper<Exam> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", examDTO.getId());
        queryWrapper.eq("password", examDTO.getPassword());
        Exam one;
        // 处理异常情况
        try {
            one = getOne(queryWrapper);//从数据库查询考试信息
        } catch (Exception e) {
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
        if(one != null){
            //判断考试时间是否合法
            DateTime dateTime = DateUtil.parse(one.getTime(), "yyyy-MM-dd HH:mm");
            Date now = new Date();
            if(DateUtil.compare(now, dateTime) < 0) {
                throw new ServiceException(Constants.CODE_600,"考试未开始");
            } else if(DateUtil.compare(now, DateUtil.offsetMinute(dateTime,one.getDuration())) > 0) {
                throw new ServiceException(Constants.CODE_600,"考试已结束");
            } else {
                BeanUtil.copyProperties(one, examDTO, true);
                return examDTO;
            }
        } else {
            throw new ServiceException(Constants.CODE_600,"ID或密码错误");
        }
    }
}
