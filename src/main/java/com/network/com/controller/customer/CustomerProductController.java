package com.network.com.controller.customer;


import com.network.com.dto.ProductDto;
import com.network.com.services.customer.CustomerProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerProductController  {



    private final CustomerProductService customerProductService;



    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto>productDtos=customerProductService.getAllProducts();
        return ResponseEntity.ok(productDtos);
    }
    @GetMapping("/search/{name")
    public ResponseEntity<List<ProductDto>>getAllProductByName(@PathVariable String name){
        List<ProductDto>productDtos=customerProductService.searchProductByTitle(name);
        return ResponseEntity.ok(productDtos);
    }
}
