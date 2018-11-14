package com.jk;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@EnableWebMvc
@SpringBootApplication
@EnableCaching
@ImportResource("classpath:spring-dubbo-provider.xml")
public class Application extends WebMvcConfigurerAdapter  {

    public static void main(String[] args) {
         SpringApplication.run(Application.class, args);
    }
    
    @RequestMapping("/")
    String home() {
        return "redirect:test2";
    }

}
