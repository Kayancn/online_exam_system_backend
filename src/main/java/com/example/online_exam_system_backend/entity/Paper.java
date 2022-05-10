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
 * 试卷表
 * </p>
 *
 * @author Kayan
 * @since 2022-05-10
 */
@Getter
@Setter
  @ApiModel(value = "Paper对象", description = "试卷表")
public class Paper implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("试卷名称")
      private String name;

      @ApiModelProperty("试卷总分")
      private Integer score;

      @ApiModelProperty("答题时长")
      private Integer duration;

      @ApiModelProperty("所属课程")
      private Integer courseId;


}
