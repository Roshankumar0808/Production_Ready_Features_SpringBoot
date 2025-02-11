package com.Production_Features_SpringBoot.Production_Features_SpringBoot.DTO;

//import com.RESTAPI1.RESTAPI1.CustomAnnotation.EmployeeCustomAnnotation;
import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.validation.constraints.*;
import lombok.*;


import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDto {
    private Long Id;
//    @NotBlank(message="Name is required")
//    @Size(min=3,max=10,message="Char length length 3-10")
    private String name;
//    @NotBlank(message = "Email cannot be blank")
//    @Email(message = "entre valid email")
    private String email;
    //Min max is used for num
//    @NotNull(message = "Age can not be blank")
//    @Max(value =80,message = "Age can't be more than 80")
//    @Min(value =20,message = "Age can't be less than 20")
    private Integer age;
//    @NotNull()
//    @Positive()
//    @Digits(integer = 3,fraction = 2)
//    @DecimalMax(value="999.99")
//    @DecimalMin(value="99.99")
    private Double salarly;
//    @PastOrPresent(message = "Date can't be future")
    private LocalDate dateOfJoining;
//    @JsonProperty("isActive")
    private Boolean isActive;
//    @NotBlank(message = "Role cannot be blank")
//    @EmployeeCustomAnnotation

  //  @Pattern(regexp = "^(ADMIN|USER)$",message="Wrong Role")
    private String role;

}
