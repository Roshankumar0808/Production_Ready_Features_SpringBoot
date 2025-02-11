package com.Production_Features_SpringBoot.Production_Features_SpringBoot.Client;

import com.Production_Features_SpringBoot.Production_Features_SpringBoot.DTO.EmployeeDto;

import java.util.List;

public interface EmployeeClient {
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(Long EmployeeId);
    EmployeeDto createNewEmployee(EmployeeDto employeeDto);

}
