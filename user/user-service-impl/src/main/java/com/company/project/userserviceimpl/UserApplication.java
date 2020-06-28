package com.company.project.userserviceimpl;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringCloudApplication
@ComponentScan("com.company.project")
@MapperScan(basePackages = {"com.company.project.*.mapper"})
@EnableFeignClients(basePackages = {"com.company.project"})
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
