package com.athnitech;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
public class AthniTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(AthniTechApplication.class, args);
	}

}
