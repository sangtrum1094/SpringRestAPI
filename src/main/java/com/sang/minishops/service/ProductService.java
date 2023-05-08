package com.sang.minishops.service;

import com.sang.minishops.entity.Product;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    Product addNewProduct(Product product);
}
