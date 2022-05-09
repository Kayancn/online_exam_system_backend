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
 * 课程表
 * </p>
 *
 * @author Kayan
 * @since 2022-05-09
 */
@Getter
@Setter
  @ApiModel(value = "Course对象", description = "课程表")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("课程id")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("课程名称")
      private String name;

      @ApiModelProperty("描述")
      private String detail;


}
