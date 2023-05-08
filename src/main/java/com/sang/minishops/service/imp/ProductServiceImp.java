package com.sang.minishops.service.imp;

import com.sang.minishops.entity.ImageModel;
import com.sang.minishops.entity.Product;
import com.sang.minishops.repository.ProductRepository;
import com.sang.minishops.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product addNewProduct(Product product){
        return productRepository.save(product);
    }

}

