package com.example.jpa.repository.OneToManyManyToOne;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Paige on 6/14/17.
 */

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {

}
