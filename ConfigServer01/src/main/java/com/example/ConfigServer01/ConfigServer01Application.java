package com.example.ConfigServer01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServer01Application {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServer01Application.class, args);
	}
}
