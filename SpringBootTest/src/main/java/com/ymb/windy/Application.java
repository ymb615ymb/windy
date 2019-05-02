package com.ymb.windy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.ymb.windy.datasource1.mapper","com.ymb.windy.datasource2.mapper"})
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
}
