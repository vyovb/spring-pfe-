package com.network.com.controller.admin;



import com.network.com.dto.CategDto;
import com.network.com.entity.Category;
import com.network.com.services.admin.category.CategService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminCategController {

    private final CategService categService;
    @PostMapping("category")
    @CrossOrigin("*")
    public ResponseEntity<Category>createCategory(@RequestBody CategDto categDto){
        Category category = categService.createCategory(categDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }
    @GetMapping("categories")
    @CrossOrigin("*")
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.ok(categService.getAllCategories());
    }
}
