package com.example.review;

import com.example.common.config.ApiLoggingFilterConfig;
import com.example.common.config.OpenApiConfig;
import com.example.common.config.WebSecurityConfig;
import com.example.common.exception.ApiExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
    OpenApiConfig.class,
    ApiLoggingFilterConfig.class,
    ApiExceptionHandler.class,
    WebSecurityConfig.class
})
public class ReviewServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReviewServiceApplication.class, args);
    }

}
