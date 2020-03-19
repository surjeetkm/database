package com.c2p.h2.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.c2p.h2.controller","com.c2p.h2.service","com.c2p.h2.swaggertest"})
@EnableJpaRepositories(basePackages = {"com.c2p.h2.repo"})
@EntityScan(basePackages = "com.c2p.h2.domain")
@EnableTransactionManagement
public class H2DbinstanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2DbinstanceApplication.class, args);
	}
}
