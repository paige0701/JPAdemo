package com.example.jpa;

import com.example.jpa.repository.ManyToMany.CategoryEntity;
import com.example.jpa.repository.ManyToMany.CategoryRepository;
import com.example.jpa.repository.ManyToMany.ProductEntity;
import com.example.jpa.repository.ManyToMany.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@Transactional
@Rollback

public class ManyToManyTest extends DemoApplicationTests{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void manyToManyTest() {

        CategoryEntity category = new CategoryEntity();
        category.setName("IT");
        categoryRepository.save(category);

        ProductEntity product = new ProductEntity();
        product.setName("MacBook");
        product.setPrice(1000);

        product.addCategory(category);
        category.addProduct(product);
        productRepository.save(product);

        Assert.assertEquals(product.getId(), category.getProducts().get(0).getId());
    }
}