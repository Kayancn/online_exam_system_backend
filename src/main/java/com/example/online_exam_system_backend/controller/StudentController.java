package com.example.online_exam_system_backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.online_exam_system_backend.entity.Student;
import com.example.online_exam_system_backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    //查询
    @GetMapping
    public List<Student> findAll() {
        return studentService.list();
    }

    //分页查询 - mybatis-plus方式
    @GetMapping("/page")
    public IPage<Student> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam(defaultValue = "") String id,
                                   @RequestParam(defaultValue = "") String name,
                                   @RequestParam(defaultValue = "") String major,
                                   @RequestParam(defaultValue = "") String clas) {
        IPage<Student> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        if(!"".equals(id)){
            queryWrapper.like("id", id);
        }
        if(!"".equals(name)){
            queryWrapper.like("name", name);
        }
        if(!"".equals(major)){
            queryWrapper.like("major", major);
        }
        if(!"".equals(clas)){
            queryWrapper.like("class", clas);
        }

        return studentService.page(page, queryWrapper);
    }

    // 新增和修改
    @PostMapping
    public boolean save(@RequestBody Student student) {
        return studentService.saveOrUpdate(student);
    }
    //删除
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        return studentService.removeById(id);
    }
    //批量删除
    @PostMapping ("/del/batch")
    public boolean deleteBatch(@RequestBody List<String> ids) {
        return studentService.removeBatchByIds(ids);
    }
}
