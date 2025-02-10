package com.Production_Features_SpringBoot.Production_Features_SpringBoot.Config;

import com.Production_Features_SpringBoot.Production_Features_SpringBoot.auth.AuditorAwareImpl;
import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAwareImpl")
public class ModelMapperConfig {
    @Bean
    public ModelMapper getmodelmapper(){
        return new ModelMapper();
    }

    @Bean
    public AuditorAware<String> getAuditorAwareImpl(){
        return new AuditorAwareImpl();
    }

}
