package com.Production_Features_SpringBoot.Production_Features_SpringBoot.Client.impl;

import com.Production_Features_SpringBoot.Production_Features_SpringBoot.Client.EmployeeClient;
import com.Production_Features_SpringBoot.Production_Features_SpringBoot.DTO.EmployeeDto;
import com.Production_Features_SpringBoot.Production_Features_SpringBoot.Exception.ResourceNotFoundException;
import com.Production_Features_SpringBoot.Production_Features_SpringBoot.advice.APIresponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.Type;
import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {
    private final RestClient restClient;
    Logger log=LoggerFactory.getLogger(EmployeeClientImpl.class);
    @Override
    public List<EmployeeDto> getAllEmployees() {
        log.trace("Trying To Retrive");

//        log.error("error log");
//        log.warn("warn log");
//        log.info("info log");
//        log.debug("debug log");
//        log.trace("trace log");
        try {
            log.info("Attempting to retrive");
         APIresponse< List<EmployeeDto> >employeeDtos = restClient.get().uri("employees").retrieve()
                 .onStatus(HttpStatusCode::is4xxClientError,(request, response) -> {
                     log.error(new String(response.getBody().readAllBytes()));
                     throw new ResourceNotFoundException("could not create the employee");
                 })
                 .body(new ParameterizedTypeReference<>() {
            });
            log.debug("Succesfully retrived the employess in getAllEmployees");
            log.trace("Retrived Employee List :{}, {}, {}",employeeDtos.getData(),"Hello",5);
            return employeeDtos.getData();

        }
        catch (Exception e){
            log.error("Exception occured in getAllEmployee",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        log.trace("Trying To Retrive:{}",employeeId);
        try{
            APIresponse<EmployeeDto> employeeDtoAPIresponse=restClient.get().uri("employees/{employeeId}",employeeId).retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(request, response) -> {
                        log.error(new String(response.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
            });
            return employeeDtoAPIresponse.getData();
        }
        catch (Exception e){
            log.error("Exception occured in getAllEmployeeId",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
        log.trace("Trying To createEmployee:{}",employeeDto);
        try{
           ResponseEntity<APIresponse<EmployeeDto>>employeeDtoAPIresponse=restClient.post()
                   .uri("employees")
                   .body(employeeDto)
                   .retrieve()
                   .onStatus(HttpStatusCode::is4xxClientError,((request, response) -> {
                       log.debug("Error Occured During  CreateNewEmployee");
                       log.error(new String(response.getBody().readAllBytes()));
                       System.out.println("Error Occured"+new String(response.getBody().readAllBytes()));
                       throw new ResourceNotFoundException("Could not create the employee");

                   }))
                   .toEntity(new ParameterizedTypeReference<>() {
           });
           log.trace("Success created a new employee:{}",employeeDtoAPIresponse.getBody());
           return employeeDtoAPIresponse.getBody().getData();
        }
        catch (Exception e){
            log.error("Exception occured in post Call Employee",e);
            throw new RuntimeException(e);
        }
    }
}
