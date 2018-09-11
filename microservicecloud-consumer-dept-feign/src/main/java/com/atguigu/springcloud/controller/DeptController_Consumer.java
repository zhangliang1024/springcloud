package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;

@RestController
public class DeptController_Consumer {
    
	//根据 服务接口地址调用服务 v1.0
	//private static final String REST_URL_PREFIX = "http://localhost:8001";
	
	/**
	 * 根据微服务的 名称来调用服务 v2.0
	 * Ribbon和Eureka整合后Consumer可以  直接调用服务  而不用再关心地址和端口号
	 * 总结：Ribbon其实就是一个软负载均衡的客户端组件
	 */
	//private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

	/*@Autowired
	private RestTemplate restTemplate;*/
	
	//-------------------------------------  feign 演示   ---------------------------------------
	
	
	@Autowired
	private DeptClientService service = null;
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		return service.add(dept);
	}
	
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") long id) {
		return this.service.get(id);
	}
	
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list() {
		return this.service.list();

	}
	
}
