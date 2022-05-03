package com.example.online_exam_system_backend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@TableName(value = "student") //指定表名
public class Student {
    @TableId //指定主键
    private String id;
    //@JsonIgnore //忽略password，不展示给前端
    private String password;
    private String name;
    private String major;
    @TableField(value = "class") //指定数据库字段名称
    private String clas;
    private String email;
    private String phone;
}
