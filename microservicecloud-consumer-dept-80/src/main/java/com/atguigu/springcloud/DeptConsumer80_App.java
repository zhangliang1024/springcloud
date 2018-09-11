package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient   //本服务启动后会  但不会注册进eureka服务中，application.yml配置过
public class DeptConsumer80_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
