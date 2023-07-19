package com.hospital.sphospital.config;


import com.hospital.sphospital.auth.PersonalUserDetailService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration()
@EnableWebSecurity()
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true, proxyTargetClass = true)
@RequiredArgsConstructor
public class SecurityConfiguration  {

    private final PersonalUserDetailService doctorDetailService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/doctors/**").hasRole("ADMIN")
//                .and()
//                .formLogin();
//
//    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager)throws Exception{


        http
                .csrf()
                .disable()
                .formLogin()
                .loginPage("/auth/login").permitAll()
                .loginProcessingUrl("/auth/process-login")
                .defaultSuccessUrl("/auth/roteuser", true)
                .failureUrl("/auth/login?error").permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/auth/login")
                .and()
                .authorizeRequests()
                .antMatchers("/doctors").hasRole("ADMIN")
                .anyRequest()
                .authenticated();

        return http.build();
        }
}
