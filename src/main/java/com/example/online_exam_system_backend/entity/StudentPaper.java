package com.example.online_exam_system_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 学生答卷表
 * </p>
 *
 * @author Kayan
 * @since 2022-05-24
 */
@Getter
@Setter
  @TableName("student_paper")
@ApiModel(value = "StudentPaper对象", description = "学生答卷表")
public class StudentPaper implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("考试id")
      private Integer examId;

      @ApiModelProperty("试卷内容")
      private String paper;

      @ApiModelProperty("学生id")
      private String studentId;

      @ApiModelProperty("提交时间")
      private String time;

      @ApiModelProperty("成绩")
      private Integer score;


}
