package com.less;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.less.dao.mapper")
@SpringBootApplication
public class LessApplication {


	public static void main(String[] args) {
		SpringApplication.run(LessApplication.class, args);

	}

}
