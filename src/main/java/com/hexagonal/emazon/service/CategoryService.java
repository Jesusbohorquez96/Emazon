package com.hexagonal.emazon.service;

import com.hexagonal.emazon.dto.CategoryDto;
import com.hexagonal.emazon.mapper.CategoryMapper;
import com.hexagonal.emazon.persistence.entity.CategoryEntity;
import com.hexagonal.emazon.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    public List<CategoryDto> obtenerCategory() {
        return categoryRepository
                .findAll()
                .stream()
                .map(categoryEntity -> categoryMapper.categoryDtoToCategoryEntity(categoryEntity))
                .collect(Collectors.toList());
    }

    public CategoryDto crearCategory(CategoryDto categoryDto) {
        CategoryEntity category = this.categoryRepository.save(
                categoryMapper.categoryEntityToCategoryDto(categoryDto)
        );
        return categoryMapper.categoryDtoToCategoryEntity(category);
    }

}
