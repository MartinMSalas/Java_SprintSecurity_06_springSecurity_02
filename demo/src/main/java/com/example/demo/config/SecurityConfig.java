package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf->csrf.disable())
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers(publicEndpoints()).permitAll()
                        .requestMatchers("/api/welcome/hellouser").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/api/welcome/helloadmin").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(withDefaults())
                .build();
    }

    private RequestMatcher publicEndpoints() {
        return new OrRequestMatcher(
                //new AntPathRequestMatcher("/api/welcome/helloprotected"),
                new AntPathRequestMatcher("/api/welcome/hellopublic")
        );
    }
}
