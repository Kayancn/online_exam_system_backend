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
 * 题目表
 * </p>
 *
 * @author Kayan
 * @since 2022-05-09
 */
@Getter
@Setter
  @ApiModel(value = "Question对象", description = "题目表")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("题目编号")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("题干")
      private String name;

      @ApiModelProperty("类型： 1：选择，2：判断，3：问答")
      private Integer type;

      @ApiModelProperty("选项a")
      private String a;

      @ApiModelProperty("选项b")
      private String b;

      @ApiModelProperty("选项c")
      private String c;

      @ApiModelProperty("选项d")
      private String d;

      @ApiModelProperty("分数")
      private Integer score;

      @ApiModelProperty("答案")
      private String answer;

      @ApiModelProperty("解析")
      private String detail;

      @ApiModelProperty("所属课程id")
      private Integer courseId;


}
