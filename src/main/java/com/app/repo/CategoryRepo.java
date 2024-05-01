package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojo.CategoryPojo;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryPojo, Long> {
}
