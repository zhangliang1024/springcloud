package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {
	@Autowired
	private DeptService service = null;

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = this.service.get(id);
		if (null == dept) {
			throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
		}
		return dept;
	}
	/**
	 * 一旦调用服务方法失败并抛出了错误信息后，
	 * 会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	 * ★ 这里注意  如果使用的@PathVariable("id") long id  参数类型必须与实体类中的类型一致，否则保存，找不到此回调方法
	 */
	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
	}
	
	@RequestMapping(value="dept/add",method=RequestMethod.POST)
	public boolean add(@RequestBody  Dept dept) {
		return service.add(dept);
	}
	
	@RequestMapping(value="dept/list",method=RequestMethod.GET)
	public List<Dept> list() {
		return service.list();
	}
}
