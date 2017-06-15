package com.example.jpa.repository.ManyToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Paige on 6/14/17.
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,String> {

}
