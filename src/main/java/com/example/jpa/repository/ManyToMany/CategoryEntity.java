package com.example.jpa.repository.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paige on 6/14/17.
 */
@Entity
@Table(name="category")
public class CategoryEntity {


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "category_id")
    private String id;

    @Column(name = "name")
    private String name;


    // 객체는 양뱡향 연관관계가 없다 서로다은 단방향 관계일뿐
    // 연관관계의 주인만이 데이터베이스 연관관계와 매핑되고 외래 키를 관리(등록 수정 삭제) 할 수 있다 반면 다른 쪽은 읽기만 한다
    // 누가 주인이니는 mappedby 로 지정한다
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "categories")
    private List<ProductEntity> products;

    // CONSTRUCTORS
    public CategoryEntity() {
    }

    public CategoryEntity(String name, List<ProductEntity> products) {
        this.name = name;
        this.products = products;
    }

    // 무한루프 방지..?
    public boolean addProduct(ProductEntity product) {
        if(products == null)
            products = new ArrayList<>();

        return products.add(product);
    }


    // getters and setters
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

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }


}
