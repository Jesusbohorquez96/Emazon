package com.hexagonal.emazon.persistence.repository;


import com.hexagonal.emazon.persistence.entity.CategoryEntity;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
