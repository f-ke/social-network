package com.uwarterloorookie.config;

import com.uwarterloorookie.component.LoginHandlerInterceptor;
import com.uwarterloorookie.component.MyLocaleReserver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration

public class MyspringMVC {
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
            WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
                @Override
                public void addViewControllers(ViewControllerRegistry registry) {
                   registry.addViewController("/").setViewName("login");
                    registry.addViewController("/main.html").setViewName("/home");
                }

                @Override
                public void addInterceptors(InterceptorRegistry registry) {
                    registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                       .excludePathPatterns("/","/user/login","/toregister","/user/register","/webjars/**","/asserts/**","/imagetest/**");
                }

                @Override
                public void addResourceHandlers(ResourceHandlerRegistry registry) {
                    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
                    registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

                }
            };

            return adapter;
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleReserver();
    }
}
