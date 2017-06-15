package com.example.jpa.repository.Testing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Paige on 6/13/17.
 */
@Repository
public interface TestRepository extends JpaRepository<TestEntity,String> {
}
