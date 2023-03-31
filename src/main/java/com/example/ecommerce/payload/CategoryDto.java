package com.example.ecommerce.payload;

import com.example.ecommerce.util.ImageNameValid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto extends BaseEntityDto{

    private Long categoryId;

    @NotBlank
    @Size(min=3 , max=10, message = "Invalid  message")
    private String title;

    @Size(min=5 ,max =20 ,message = "Invalid Description")
    private String description;

    @ImageNameValid
    private String  coverImage;
}
