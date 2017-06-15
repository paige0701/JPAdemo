package com.example.jpa.repository.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paige on 6/14/17.
 */
@Entity
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "product_id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private int Price;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="product_category",
            joinColumns = @JoinColumn(name="product_id", referencedColumnName = "product_id"),
            inverseJoinColumns = @JoinColumn(name="category_id", referencedColumnName = "category_id"))
    private List<CategoryEntity> categories;



    // 무한루프 방지..
    public boolean addCategory(CategoryEntity category) {
        if(categories == null)
            categories = new ArrayList<>();

        return categories.add(category);
    }

    // Constructors
    public ProductEntity() {}

    public ProductEntity(String name, int price) {
        this.name = name;
        this.Price = price;
    }

    // Getters and setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }
}
