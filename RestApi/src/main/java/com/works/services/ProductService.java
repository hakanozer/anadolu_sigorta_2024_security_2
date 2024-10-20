package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import com.works.utils.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public ResponseEntity save(Product product) {
        productRepository.save(product);
        return Rest.success(product);
    }

    public ResponseEntity list() {
        List<Product> productList = productRepository.findAll();
        return Rest.success(productList);
    }


}
