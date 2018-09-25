package com.cecdat.np.config;

import com.cecdat.np.auth.AuthenctiationFailureHandler;
import com.cecdat.np.auth.AuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    AuthenctiationFailureHandler authenctiationFailureHandler;

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> detailsSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login","/register","/vcode/**","/webjars/**","/js/**","/css/**","/images/**","/fonts/**").permitAll()
                  .anyRequest().permitAll()
//                .anyRequest().authenticated()
                .and()
                .formLogin()
                .authenticationDetailsSource(detailsSource)
                .loginPage("/login")
                .failureHandler(authenctiationFailureHandler)
                .successHandler(authenticationSuccessHandler)
                .and()
                .logout()
                .permitAll()
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}