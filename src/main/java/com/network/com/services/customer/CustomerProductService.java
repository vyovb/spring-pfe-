package com.network.com.services.customer;


import com.network.com.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerProductService {

    List<ProductDto> searchProductByTitle(String title);
    List<ProductDto> getAllProducts();
}
