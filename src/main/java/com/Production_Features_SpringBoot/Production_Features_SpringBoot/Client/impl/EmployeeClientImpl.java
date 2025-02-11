package com.Production_Features_SpringBoot.Production_Features_SpringBoot.Client.impl;

import com.Production_Features_SpringBoot.Production_Features_SpringBoot.Client.EmployeeClient;
import com.Production_Features_SpringBoot.Production_Features_SpringBoot.DTO.EmployeeDto;
import com.Production_Features_SpringBoot.Production_Features_SpringBoot.Exception.ResourceNotFoundException;
import com.Production_Features_SpringBoot.Production_Features_SpringBoot.advice.APIresponse;
import lombok.RequiredArgsConstructor;
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

    @Override
    public List<EmployeeDto> getAllEmployees() {
        try {
         APIresponse< List<EmployeeDto> >employeeDtos = restClient.get().uri("employees").retrieve().body(new ParameterizedTypeReference<>() {
            });
            return employeeDtos.getData();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        try{
            APIresponse<EmployeeDto> employeeDtoAPIresponse=restClient.get().uri("employees/{employeeId}",employeeId).retrieve().body(new ParameterizedTypeReference<>() {
            });
            return employeeDtoAPIresponse.getData();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
        try{
           ResponseEntity<APIresponse<EmployeeDto>>employeeDtoAPIresponse=restClient.post()
                   .uri("employees")
                   .body(employeeDto)
                   .retrieve()
                   .onStatus(HttpStatusCode::is4xxClientError,((request, response) -> {
                       System.out.println("Error Occured"+new String(response.getBody().readAllBytes()));
                       throw new ResourceNotFoundException("Could not create the employee");

                   }))
                   .toEntity(new ParameterizedTypeReference<>() {
           });
           return employeeDtoAPIresponse.getBody().getData();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
