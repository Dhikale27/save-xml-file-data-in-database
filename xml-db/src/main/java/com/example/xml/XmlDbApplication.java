package com.example.xml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.xml.model.Food;
import com.example.xml.service.FoodService;

@SpringBootApplication
public class XmlDbApplication implements CommandLineRunner {
	
	@Autowired
	private FoodService foodService;
	
	public static void main(String[] args) {
		SpringApplication.run(XmlDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Food> savedFoods = this.foodService.saveFoods();
		
		savedFoods.forEach(food->{
			System.out.println("Id : " + food.getId());
			System.out.println("Name : " + food.getName());
			System.out.println("Price : " + food.getPrice());
			System.out.println("Description : " + food.getDescription());
			System.out.println("Calories : " + food.getCalories());
			System.out.println();
			System.out.println("-------------------------------------------------------------");
		});
		
	}

}
