package com.thitracnghiem.api.entities.question.repos;

import com.thitracnghiem.api.entities.question.entities.Category;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>, JpaSpecificationExecutor<Category> {
   Category findByTenCategory(String name);
   boolean existsByTenCategory( String name);
}
