package com.example.online_exam_system_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class OnlineExamSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineExamSystemBackendApplication.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "ok";
    }
}
