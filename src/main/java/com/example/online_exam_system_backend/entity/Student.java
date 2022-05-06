package com.example.online_exam_system_backend.entity;

import java.io.Serializable;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 学生表
 * </p>
 *
 * @author Kayan
 * @since 2022-05-05
 */
@Getter
@Setter
  @ApiModel(value = "Student对象", description = "学生表")
@ToString
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("学号")
      @Alias("学号")
        private String id;

      @ApiModelProperty("密码")
      @Alias("密码")
      private String password;

      @ApiModelProperty("姓名")
      @Alias("姓名")
      private String name;

      @ApiModelProperty("专业")
      @Alias("专业")
      private String major;

      @ApiModelProperty("班级")
      @TableField("class")
      @Alias("班级")
      private String clas;

      @ApiModelProperty("邮箱")
      @Alias("邮箱")
      private String email;

      @ApiModelProperty("电话")
      @Alias("电话")
      private String phone;


}
