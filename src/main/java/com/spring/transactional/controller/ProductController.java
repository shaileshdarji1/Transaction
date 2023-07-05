package com.spring.transactional.controller;

import com.spring.transactional.entity.Product;
import com.spring.transactional.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;

@RestController
@RequestMapping("/api/product")

public class ProductController {

    @Autowired
    ProductService productService;

    Scanner sc = new Scanner(System.in);
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    @PostMapping("/read-uncommitted")
    public Product updateProduct(@RequestBody Product product){
        TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        if(status.isNewTransaction())
        {
            System.out.println("Controller Transaction is active && New Transaction is created");
        }
        else{
            System.out.println("Controller Transaction is used existing");
        }
        Product product1 = productService.saveProduct(product);

           System.out.println("1.Rollback");
           System.out.println("2.commit");
           int num = sc.nextInt();
           if(num==1){
               System.out.println("nms is:" + num);
               throw new RuntimeException("Runtime Exception Occurs");
           }
           else {
               return product1;
           }

    }

    @RequestMapping("/{id}")
    public Product getProduct(@PathVariable Integer id){
        return productService.getProduct(id);
    }
}
