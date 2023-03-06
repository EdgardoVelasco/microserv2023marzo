package com.netec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@RibbonClient(name = "micro-articulo")
@EnableFeignClients
@SpringBootApplication
public class MicroCarritoFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroCarritoFeignApplication.class, args);
	}

}
