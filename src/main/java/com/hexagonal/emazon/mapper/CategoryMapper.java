package com.hexagonal.emazon.mapper;


import com.hexagonal.emazon.dto.CategoryDto;
import com.hexagonal.emazon.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface  CategoryMapper {

    CategoryDto categoryDtoToCategoryEntity(CategoryEntity categoryDto);

    CategoryEntity categoryEntityToCategoryDto(CategoryDto categoryDto);

}
