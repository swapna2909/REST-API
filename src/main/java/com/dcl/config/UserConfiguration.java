package com.dcl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class UserConfiguration {
	
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
}
