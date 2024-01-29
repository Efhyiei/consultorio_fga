package com.fga.consultorio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                .requestMatchers("/api/v1/consulting//*users/auth/**", "/css/**", "/js/**").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        //.loginPage("/api/v1/consulting/users/auth/login")
                        .defaultSuccessUrl("/api/v1/consulting/view/appointment/create")
                        .loginProcessingUrl("/api/v1/consulting/users/auth/login")
                        .failureUrl("/api/v1/consulting/users/auth/login?error")
                        .permitAll()
                ).logout( logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/api/v1/consulting/users/auth/logout")).permitAll()
                ).build();
        }
}
