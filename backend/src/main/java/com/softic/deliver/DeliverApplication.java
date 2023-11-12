package com.softic.deliver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeliverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliverApplication.class, args);
		
		
		for(int i=0; i<100;i++) {
			int a=3;
			a=a+3; 
			System.out.println(i);
		}
	}

}
