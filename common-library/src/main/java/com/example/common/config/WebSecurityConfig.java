package com.example.common.config;

import com.example.common.filter.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
@EnableWebSecurity
@ConditionalOnExpression("${api.security.enabled:true}")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    WebAuthenticationEntryPoint webAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
            .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
            .mvcMatchers(HttpMethod.GET, "/**").permitAll()
            .mvcMatchers(HttpMethod.POST, "/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(webAuthenticationEntryPoint);
    }

    @Bean
    WebAuthenticationEntryPoint webAuthenticationEntryPoint(HandlerExceptionResolver handlerExceptionResolver) {
        return new WebAuthenticationEntryPoint(handlerExceptionResolver);
    }
}
