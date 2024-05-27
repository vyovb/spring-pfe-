package com.network.com.services.admin.category;


import com.network.com.dto.CategDto;
import com.network.com.entity.Category;
import com.network.com.repository.CategRepo;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategServiceImpl implements CategService{
    private final CategRepo categRepo;
    public Category createCategory(CategDto categDto){
        Category category=new Category();
        category.setName(categDto.getName());
        category.setDescription(categDto.getDescription());
        return categRepo.save(category);
    }


    public List<Category> getAllCategories(){
        return categRepo.findAll();
    }

}

