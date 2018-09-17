package com.ttylink;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * <p>Title: App</p>
 * <p>Description:SpringBoot项目启动加载类</p>
 * @author lixin06
 * @date 2018年9月12日
 * @version 1.0.0
 */
//@SpringBootApplication(scanBasePackages ="com.zhihao.miao")
@SpringBootApplication(scanBasePackages = "com.ttylink")
//@ComponentScan("com.ttylink")
@MapperScan("com.ttylink.dao")
public class App {
	
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(App.class);
		springApplication.setBannerMode(Banner.Mode.CONSOLE);
		springApplication.run(args);
//		SpringApplication.run(App.class, args);
	}

}
