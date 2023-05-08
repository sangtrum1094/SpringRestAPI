package com.sang.minishops.controller;

import com.sang.minishops.entity.ImageModel;
import com.sang.minishops.entity.Product;
import com.sang.minishops.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
public class ProductController {
     @Autowired
    ProductService productService;

     @GetMapping("/addproduct")
     public String addImageProduct(){
        return "addproduct";
     };
    @PostMapping(value = {"/addproduct"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String addNewProduct(@RequestPart("product") Product product,
                                @RequestPart("productImage") MultipartFile[] file){
        try {
            Set<ImageModel> images = uploadImage(file);
            product.setProductImage(images);
            productService.addNewProduct(product);
            return "redirect:/products";
        } catch (Exception e){
            System.out.println(e.getMessage());
            return "error";
        }
    }
    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels= new HashSet<>();

        for(MultipartFile file: multipartFiles){
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }

}
