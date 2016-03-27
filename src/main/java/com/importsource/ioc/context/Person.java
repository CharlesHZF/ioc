package com.importsource.ioc.context;

/**
 * 这个就是那个待测试类
 * @author Hezf
 *
 */
public class Person {
	
	//@Autowired
	Resource resource;
	
	
	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
