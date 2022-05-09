package com.example.online_exam_system_backend.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.online_exam_system_backend.service.IStudentService;
import com.example.online_exam_system_backend.entity.Student;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 学生表 前端控制器
 * </p>
 *
 * @author Kayan
 * @since 2022-05-05
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private IStudentService studentService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody Student student) {
        return studentService.saveOrUpdate(student);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return studentService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return studentService.removeByIds(ids);
    }

    @GetMapping
    public List<Student> findAll() {
        return studentService.list();
    }

    @GetMapping("/{id}")
    public Student findOne(@PathVariable String id) {
        return studentService.getById(id);
    }

    @GetMapping("/page")
    public Page<Student> findPage(@RequestParam Integer pageNum,
                                  @RequestParam Integer pageSize,
                                  @RequestParam(defaultValue = "") String id,
                                  @RequestParam(defaultValue = "") String name,
                                  @RequestParam(defaultValue = "") String major,
                                  @RequestParam(defaultValue = "") String clas) {
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
        return studentService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }
    //导出
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Student> list = studentService.list();
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
//        writer.addHeaderAlias("id", "学号");
//        writer.addHeaderAlias("password", "密码");
//        writer.addHeaderAlias("name", "姓名");
//        writer.addHeaderAlias("major", "专业");
//        writer.addHeaderAlias("clas", "班级");
//        writer.addHeaderAlias("email", "邮箱");
//        writer.addHeaderAlias("phone", "电话");

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("学生信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }
    //excel导入
    @PostMapping("/import")
    public Boolean imp(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        // 方式1：(推荐) 通过 javabean的方式读取Excel内的对象，但是要求表头必须是英文（通过hutool的@Alias属性在entity中设置属性的中文别名即可解决），跟javabean的属性要对应起来
        List<Student> students = reader.readAll(Student.class);
//        System.out.println(list);
        // 方式2：忽略表头的中文，直接读取表的内容
//        List<List<Object>> list = reader.read(1);
//        List<Student> students = CollUtil.newArrayList();
//        for (List<Object> row : list) {
//            Student student = new Student();
//            student.setId(row.get(0).toString());
//            student.setPassword(row.get(1).toString());
//            student.setName(row.get(2).toString());
//            student.setMajor(row.get(3).toString());
//            student.setClas(row.get(4).toString());
//            student.setEmail(row.get(5).toString());
//            student.setPhone(row.get(6).toString());
//
//            students.add(student);
//        }

        studentService.saveBatch(students);
        return true;
    }
}

