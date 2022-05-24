package com.example.online_exam_system_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 考试表
 * </p>
 *
 * @author Kayan
 * @since 2022-05-09
 */
@Getter
@Setter
  @ApiModel(value = "Exam对象", description = "考试表")
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("编号")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("考试名称")
      private String name;

      @ApiModelProperty("考试开始时间")
      private String time;

      @ApiModelProperty("负责老师")
      private String teacherId;

      @ApiModelProperty("试卷id")
      private Integer paperId;

      @ApiModelProperty("课程id")
      private Integer courseId;

      @ApiModelProperty("考试密码")
      private String password;

      @ApiModelProperty("考试时长")
      private Integer duration;

}
