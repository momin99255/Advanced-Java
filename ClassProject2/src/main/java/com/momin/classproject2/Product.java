package com.momin.classproject2;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.message.Message;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @NotBlank(message = "name is requred")
    private String name;
    @Size(min = 1, max = 5, message = "ID must be between 1 and 5 characters")
    private String id;
    @NotBlank(message = "category id required")
    private String category;
    @NotNull(message = "Stock is required")
    @Min(value = 0, message = "Stock cannot be negative")
    private Integer stock;
    @NotNull(message = "Set the price")
    @Min(value = 1, message = "Price must be greater than 0")
    private Double price;
}

