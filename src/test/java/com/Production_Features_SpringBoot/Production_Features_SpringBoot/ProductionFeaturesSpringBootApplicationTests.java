package com.Production_Features_SpringBoot.Production_Features_SpringBoot;

import com.Production_Features_SpringBoot.Production_Features_SpringBoot.Client.EmployeeClient;
import com.Production_Features_SpringBoot.Production_Features_SpringBoot.DTO.EmployeeDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductionFeaturesSpringBootApplicationTests {
   @Autowired
   private EmployeeClient employeeClient;
	@Test
	@Order(2)
	void getAllEmployees()
	{
		List<EmployeeDto> employeeDtoList=employeeClient.getAllEmployees();
		System.out.println(employeeDtoList);
	}

	@Test
	@Order(3)
	void getEmployeesById() {
		EmployeeDto employeeDto=employeeClient.getEmployeeById(3L);
		System.out.println(employeeDto);
	}


	@Test
	@Order(1)
	void createNewEmployee(){
		EmployeeDto employeeDto=new EmployeeDto(null,"Roshan","roshan@gmail.com",20,199.02, LocalDate.of(2024,12,1),true,"USER");
		EmployeeDto saveemployeeDto=employeeClient.createNewEmployee(employeeDto);
	   System.out.println(saveemployeeDto);
	}
}
