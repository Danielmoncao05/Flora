package com.senai.Flora.Infrastructure.security;

import com.senai.Flora.Infrastructure.jwt.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public FilterRegistrationBean<JwtAuthFilter> jwtFilter(){
        FilterRegistrationBean<JwtAuthFilter>registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(jwtAuthFilter);
        registrationBean.addUrlPatterns("/enviroment/*"); // * vai proteger todas as rotas de ambiente
        return registrationBean;
    }
}
