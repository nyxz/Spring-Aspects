package com.test.aspect.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.test.aspect.TimeLogger;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = {TimeLogger.class})
public class WebConfig extends WebMvcConfigurerAdapter {

}
