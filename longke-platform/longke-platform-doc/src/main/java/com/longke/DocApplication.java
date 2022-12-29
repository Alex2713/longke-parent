package com.longke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Alex
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DocApplication {
    public static void main(String[] args) {
        // Spring Boot快速启动程序
        SpringApplication.run(DocApplication.class, args);
    }
}
