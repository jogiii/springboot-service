package com.example.product.config;

import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;

public class FeignClientConfig {

    /**
     * Enable this bean if you want to add headers in HTTP request
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("content-type", "application/json");
            requestTemplate.header("accept", "application/json");
            requestTemplate.header("accept-encoding", "gzip");
            requestTemplate.header("cache-control", "no-cache");
            requestTemplate.header("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36");
        };
    }

    /**
     * Enable this bean if you want to add basic Authorization header
     * for e.g. Authorization: Basic dXNlcm5hbWU6cGFzc3dvcmQ=
     */
    //@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("username", "password");
    }
}
