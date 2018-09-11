package com.atguigu.springcloud.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@SuppressWarnings("serial")
@NoArgsConstructor //添加无参构造器
@Data              //添加getter setter方法
@Accessors(chain=true) //链式调用
public class Dept implements Serializable{ //必须实现序列化，要在网络中传输

	private Long deptno; // 主键
	private String dname; // 部门名称
	private String db_source;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
	
	public Dept(String dname) {
		super();
		this.dname = dname;
	}
}
