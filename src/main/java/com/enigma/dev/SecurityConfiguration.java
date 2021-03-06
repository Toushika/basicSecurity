package com.enigma.dev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
                .and()
                .withUser("toushika").password(passwordEncoder().encode("toushika")).roles("MANAGER")
                .and()
                .withUser("user").password(passwordEncoder().encode("user")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
               .antMatchers("/index.html").permitAll()
               .antMatchers("/profile/**").authenticated()
               .antMatchers("/admin/**").hasRole("ADMIN")
               .antMatchers("/manager/**").hasAnyRole("ADMIN","MANAGER")
               .antMatchers("/api/test1").hasAnyRole("ADMIN")
               .antMatchers("/api/test2").authenticated()
               .and()
               .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder (){
        return  new BCryptPasswordEncoder();
    }
}
