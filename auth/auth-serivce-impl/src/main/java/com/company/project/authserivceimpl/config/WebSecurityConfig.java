package com.company.project.authserivceimpl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring security 配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 密码编码验证器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 自定义UserDetailsService用来从数据库中根据用户名查询用户信息以及角色信息
     */
    @Autowired
    public UserDetailsService userDetailsService;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    /**
     * 验证配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/**").authenticated()
                .and()
                //定义哪些url需要被保护  哪些不需要保护
                .authorizeRequests()
                //定义这两个链接不需要登录可访问
                .antMatchers("/oauth/token", "oauth/check_token").permitAll()
                //定义所有的都不需要登录  目前是测试需要
                .antMatchers("/**").permitAll()
                //其他的都需要登录
                .anyRequest().authenticated()
                .and()
                //如果未登录则跳转登录的页面   这儿可以控制登录成功和登录失败跳转的页面
                .formLogin().loginPage("/index").loginProcessingUrl("/login")
                //.successForwardUrl("/home")
                //定义号码与密码的parameter
                .usernameParameter("username").passwordParameter("password").permitAll()
                .and()
                .requestMatchers().antMatchers(HttpMethod.OPTIONS, "/oauth/**")
                .and()
                .cors()
                .and()
                .csrf().disable()
                .userDetailsService(userDetailsService)
        ;
    }
}