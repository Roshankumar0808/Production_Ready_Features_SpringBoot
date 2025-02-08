package com.Production_Features_SpringBoot.Production_Features_SpringBoot.DTO;

import jakarta.persistence.Table;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class postDto {
   private Long id;
    private String title;
    private String description;
}
