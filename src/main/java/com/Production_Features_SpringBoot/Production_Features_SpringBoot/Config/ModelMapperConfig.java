package com.Production_Features_SpringBoot.Production_Features_SpringBoot.Config;

import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getmodelmapper(){
        return new ModelMapper();
    }

}
