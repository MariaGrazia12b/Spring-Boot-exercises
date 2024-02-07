package com.example.Interceptor01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*write a Spring Boot application with the necessary dependencies that:
		has 2 controllers:
		BasicController that:
		is mapped on time
		returns the current date/time OK
		LegacyController that:
		is mapped on legacy
		returns This is just old code OK
		has 2 interceptors/middleware:
		APILoggingInterceptor that prints in the console the requests header User-Agent, before handling them
		LegacyIntercepotr that:
		blocks the API calls to the legacy endpoint
		returns a response with the right HTTP code status for Gone
		test the 2 API endpoint calls using Postman*/

@SpringBootApplication
public class Interceptor01Application {

	public static void main(String[] args) {
		SpringApplication.run(Interceptor01Application.class, args);
	}

}
