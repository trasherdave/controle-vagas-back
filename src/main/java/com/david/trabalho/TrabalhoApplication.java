package com.david.trabalho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaRepositories("com.david.trabalho.repository")
public class TrabalhoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrabalhoApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer TrabalhoConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                 registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("PUT","GET","POST","DELETE")
                        .allowedHeaders("Content-Type","X-ANY-NON-STANDARD-HEADERS")
                        .exposedHeaders("*");
            }
        };
    }

}
