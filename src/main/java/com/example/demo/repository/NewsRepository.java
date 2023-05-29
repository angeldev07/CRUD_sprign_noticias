package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.NewsEntity;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Integer>{
    
}
