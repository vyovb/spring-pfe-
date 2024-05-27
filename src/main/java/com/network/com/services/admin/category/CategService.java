package com.network.com.services.admin.category;

import com.network.com.dto.CategDto;
import com.network.com.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface CategService{
    Category createCategory(CategDto categDto);
    List<Category> getAllCategories();
}
