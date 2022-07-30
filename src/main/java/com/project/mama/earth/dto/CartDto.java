package com.project.mama.earth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private String username;
    private String productName;
    private Integer quantity;
    private Long price;
}
