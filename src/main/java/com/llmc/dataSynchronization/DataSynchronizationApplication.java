package com.llmc.dataSynchronization;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.llmc.dataSynchronization.mapper")
public class DataSynchronizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataSynchronizationApplication.class, args);
	}

}
