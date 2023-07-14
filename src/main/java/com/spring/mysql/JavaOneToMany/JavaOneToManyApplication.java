package com.spring.mysql.JavaOneToMany;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaOneToManyApplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI()
				.info(new Info()
						.title("ManyToOne relation example")
						.version("0.11")
						.description("SpringBoot + Mysql + Swagger + JWT Project"));
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaOneToManyApplication.class, args);
	}

}
