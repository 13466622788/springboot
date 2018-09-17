package com.ttylink;

import java.util.List;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * <p>
 * Title: TestSpringBoot
 * </p>
 * <p>
 * Description:测试搭建SpringBoot项目
 * </p>
 * 
 * @author lixin06
 * @date 2018年9月12日
 * @version 1.0.0
 */
// @EnableAutoConfiguration
@RestController
public class TestSpringBoot {

	/*public static void main(String[] args) {
		// SpringApplication.run(TestSpringBoot.class, args);
	}*/

	@RequestMapping("/")
	public String hello() {
		System.out.println("first springboot");
		return "hello world !";
	}
}
