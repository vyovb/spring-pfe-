package com.network.com.services.customer;



import com.network.com.dto.ProductDto;
import com.network.com.entity.Product;
import com.network.com.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerProductServiceImpl implements CustomerProductService {
    private final ProductRepo productRepo;

    public List<ProductDto>getAllProducts(){
        List<Product>products=productRepo.findAll();
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }
    public List<ProductDto>searchProductByTitle(String name){
        List<Product>products=productRepo.findAllByNameContaining(name);
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }

}
