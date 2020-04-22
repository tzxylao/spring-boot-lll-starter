package com.company.project.producerserviceimpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan("com.company.project")
@MapperScan(basePackages = {"com.company.project.*.mapper"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.company.project"})
public class ProducerServiceImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerServiceImplApplication.class, args);
	}

}
