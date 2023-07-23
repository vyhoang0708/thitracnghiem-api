package com.thitracnghiem.api.modules.category;

import com.thitracnghiem.api.entities.question.entities.Category;
import com.thitracnghiem.api.entities.question.repos.CategoryRepository;
import com.thitracnghiem.api.entities.question.repos.QuestionRepository;
import com.thitracnghiem.api.payload.request.question.CategoryRequest;
import com.thitracnghiem.common.http.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.thitracnghiem.api.base.CRUDBaseServiceImpl;

import java.util.Optional;

@Slf4j
@Transactional
@Service
public class CategoryService extends CRUDBaseServiceImpl<Category, CategoryRequest, Category, Long>{
    private final CategoryRepository categoryRepository;
    @Autowired
    QuestionRepository questionRepository;
    public CategoryService(CategoryRepository categoryRepository){
        super(Category.class, CategoryRequest.class, Category.class, categoryRepository);
        this.categoryRepository = categoryRepository;
    }
    @Value("${jwkFile}")
    private Resource jwkFile;
    public Iterable<Category> getAllCategory() {
        return categoryRepository.findAll();
    }


    public ApiResponse<?> createCategory(CategoryRequest categoryRequest) {
        if(categoryRepository.existsByTenCategory(categoryRequest.getTenLoai()))
            return ApiResponse.builder().status(100).data(null).message("Danh mục đã tồn tại").build();
        Category newCategory = Category.builder().tenCategory(categoryRequest.getTenLoai()).build();
        categoryRepository.save(newCategory);
        return ApiResponse.builder().status(200).data(newCategory).message("Danh mục đã được thêm").build();
    }
    public ApiResponse<Object> updateCategory(Long id, CategoryRequest categoryRequest) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            category.get().setTenCategory(categoryRequest.getTenLoai());
            categoryRepository.save(category.get());
            return ApiResponse.builder().status(200).data(category).message("Cập nhật thành công").build();
        } else {
            return ApiResponse.builder().status(0).data(null).message("Danh mục không tồn tại").build();
        }
    }
    public ApiResponse<?> deleteCategory(Long id) {

        Optional<Category> category = categoryRepository.findById(id);
        System.out.println(category.get().toString());
        if (category.isPresent()) {
            if (questionRepository.findByCategory_IdCategory(category.get().getIdCategory()).isPresent())
                return ApiResponse.builder().status(0).data(category).message("Danh mục đã có câu hỏi không thể xóa").build();
            categoryRepository.delete(category.get());
            return ApiResponse.builder().status(200).data(category).message("Cập nhật thành công").build();
        } else {
            return ApiResponse.builder().status(0).data(null).message("Danh mục không tồn tại").build();
        }
    }

}
