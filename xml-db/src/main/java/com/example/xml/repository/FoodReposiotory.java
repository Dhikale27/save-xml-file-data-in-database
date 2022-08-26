package com.example.xml.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.xml.model.Food;

@Repository
public interface FoodReposiotory extends JpaRepository<Food, Integer> {

}
