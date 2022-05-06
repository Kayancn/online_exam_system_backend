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
 * 选择题表
 * </p>
 *
 * @author Kayan
 * @since 2022-05-05
 */
@Getter
@Setter
  @TableName("multiple_choice_question")
@ApiModel(value = "MultipleChoiceQuestion对象", description = "选择题表")
public class MultipleChoiceQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("题目编号")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("所属课程")
      private String course;

      @ApiModelProperty("选项A")
      private String optionA;

      @ApiModelProperty("选项B")
      private String optionB;

      @ApiModelProperty("选项C")
      private String optionC;

      @ApiModelProperty("选项D")
      private String optionD;

      @ApiModelProperty("答案")
      private String answer;

      @ApiModelProperty("解释")
      private String explanation;


}
