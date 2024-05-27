package com.network.com.services.admin.adminproduct;


import com.network.com.dto.ProductDto;
import com.network.com.entity.Category;
import com.network.com.entity.Product;
import com.network.com.repository.CategRepo;
import com.network.com.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminProductServiceImpl implements AdminProductService{


    private final ProductRepo productRepo;

    private final CategRepo categRepo;

    public ProductDto addProduct(ProductDto productDto) throws IOException {
        Product product =new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImg(productDto.getImg().getBytes());
        Category category=categRepo.findById(productDto.getCategoryId()).orElseThrow();
        product.setCategory(category);
        return productRepo.save(product).getDto();

    }
    public List<ProductDto>getAllProducts(){
        List<Product>products=productRepo.findAll();
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }
    public List<ProductDto>getAllProductByName(String name){
        List<Product>products=productRepo.findAllByNameContaining(name);
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }
    public boolean deleteProduct(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()) {
            productRepo.deleteById(id);
            return true;
        }
        return false;
    }
    }




