package com.api.data_cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DataCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataCacheApplication.class, args);
	}

}
