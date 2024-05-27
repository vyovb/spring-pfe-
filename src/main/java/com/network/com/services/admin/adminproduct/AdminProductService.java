 package com.network.com.services.admin.adminproduct;



import com.network.com.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service

public interface AdminProductService {
    List<ProductDto> getAllProducts();
    public ProductDto addProduct(ProductDto productDto) throws IOException;

    List<ProductDto>getAllProductByName(String name);
    public boolean deleteProduct(Long id);

}
