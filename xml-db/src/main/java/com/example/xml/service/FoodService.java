package com.example.xml.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xml.model.Food;
import com.example.xml.payloads.FoodData;
import com.example.xml.payloads.XmlFoodList;
import com.example.xml.repository.FoodReposiotory;

@Service
public class FoodService {
	@Autowired
	private XmlFoodList xmlFoodList;
	
	@Autowired
	private FoodReposiotory foodReposiotory;
	
	
	
	public List<Food> saveFoods() {
		
		List<FoodData> foodDatas = this.xmlFoodList.getFoodsFromXmlFile();
		
		List<Food> foods = foodDatas.stream()
			.map(foodData -> foodDataToFood(foodData))
			.collect(Collectors.toList());
		
		
		List<Food> savedFoods = this.foodReposiotory.saveAll(foods);
		
		
		return savedFoods;
	}
	
	private Food foodDataToFood(FoodData foodData) {
		Food food = new Food();
		
		food.setName(foodData.getName());
		food.setPrice(foodData.getPrice());
		food.setDescription(foodData.getDescription());
		food.setCalories(foodData.getCalories());
		
		return food;
	}
}
