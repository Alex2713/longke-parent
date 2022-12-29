package com.longke.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex
 */
@RefreshScope
@RestController
@RequestMapping("/")
public class IndexController {
    @Value("${test: -1}")
    private Integer test;

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/test")
    public String getTest() {
        return test + "";
    }
}
