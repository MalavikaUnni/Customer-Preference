package com.cts.superstore.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Configuration
public @Data class GetMessage {

	@Value("${my.message:default value}")
	private String message;

}
