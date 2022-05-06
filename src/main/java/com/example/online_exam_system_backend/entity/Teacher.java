package com.example.online_exam_system_backend.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 教师表
 * </p>
 *
 * @author Kayan
 * @since 2022-05-06
 */
@Getter
@Setter
  @ApiModel(value = "Teacher对象", description = "教师表")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("教师id")
        private String id;

      @ApiModelProperty("密码")
      private String password;

      @ApiModelProperty("教师姓名")
      private String name;

      @ApiModelProperty("邮箱")
      private String email;

      @ApiModelProperty("电话")
      private String phone;


}
