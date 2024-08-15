package com.hexagonal.emazon.controller;


import com.hexagonal.emazon.dto.CategoryDto;
import com.hexagonal.emazon.error.ErrorCategoryCampos;
import com.hexagonal.emazon.error.ErrorResponse;
import com.hexagonal.emazon.mapper.CategoryMapper;
import com.hexagonal.emazon.persistence.entity.CategoryEntity;
import com.hexagonal.emazon.persistence.repository.CategoryRepository;
import com.hexagonal.emazon.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorys")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    private List<CategoryDto> obtenerCategory() {
        return categoryService.obtenerCategory();
    }

    @PostMapping
    private CategoryDto crearCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.crearCategory(categoryDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> validateCategoryEntity(Exception ex) {
        // Asume que el problema es general para ambos campos ("name" y "description").
        ErrorResponse errorResponse = new ErrorResponse(
                "general",
                "name must be unique and a maximun of 50 characters," +
                        " Description must is required and a maximun of 90 characters"); // El valor rechazado no está claro aquí, por lo tanto, se deja vacío.

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}


