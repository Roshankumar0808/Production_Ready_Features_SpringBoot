package com.Production_Features_SpringBoot.Production_Features_SpringBoot.Config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
public class RestClientConfig {
    @Value("${employeeService.base.url}")
    private  String BaseUrl;

    @Bean
    @Qualifier("employeeServiceRestClient")
    RestClient getEmployeeServiceRestClient(){
        return RestClient.builder().baseUrl(BaseUrl).defaultHeader(CONTENT_TYPE,APPLICATION_JSON_VALUE)
                .defaultStatusHandler(HttpStatusCode::is5xxServerError,(req,res)->{
                    throw new RuntimeException("Server error occurred");
                })
        .build();
    }

}
