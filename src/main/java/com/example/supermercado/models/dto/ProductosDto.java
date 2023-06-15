package com.example.supermercado.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductosDto implements Serializable {

    @NotEmpty(message = "el campo debe de ser vacio")
    private String producto;




}
