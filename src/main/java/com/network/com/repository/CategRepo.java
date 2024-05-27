package com.network.com.repository;


import com.network.com.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategRepo extends JpaRepository<Category,Long> {
}
