package com.sudip.blogify.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class CategoryDTO {

    private int categoryId;
    private String categoryTitle;
    private String categoryDescription;


}