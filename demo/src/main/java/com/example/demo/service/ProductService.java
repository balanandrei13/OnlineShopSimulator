package com.example.demo.service;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addNewProduct(Product product){
        product.setId(UUID.randomUUID().toString().split("=")[0]);
        return productRepository.save(product);
    }
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(String id){
        return productRepository.findById(id).get();
    }
    public Product updateProduct(Product product){
        Product existingProduct=productRepository.findById(product.getId()).get();
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setImageURL(product.getImageURL());
        existingProduct.setDescription(product.getDescription());

        return  productRepository.save(existingProduct);
    }
    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }
}
