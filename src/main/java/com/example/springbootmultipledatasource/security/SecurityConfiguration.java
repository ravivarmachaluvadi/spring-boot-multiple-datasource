/*
package com.example.springbootmultipledatasource.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("ravi").password("rupa").roles("USER")
                .and()
                .withUser("deva").password("king").roles("ADMIN","USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/employee/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/employee/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/employee/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/employee/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/employee/**").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER")
                .antMatchers("/**").permitAll()
                .and().csrf().disable()
                .formLogin().disable();//formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
*/
