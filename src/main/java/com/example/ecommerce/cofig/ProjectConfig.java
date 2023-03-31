package com.example.ecommerce.cofig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
   public ModelMapper mdoelMapper(){

        return  new ModelMapper();
   }
}
