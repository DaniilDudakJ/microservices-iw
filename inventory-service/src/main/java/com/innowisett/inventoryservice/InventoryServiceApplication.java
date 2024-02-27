package com.innowisett.inventoryservice;

import com.innowisett.inventoryservice.model.Inventory;
import com.innowisett.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.innowisett.inventoryservice.controller", "com.innowisett.inventoryservice.service", "com.innowisett.inventoryservice.repository"})

public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args ->{
			Inventory inventory = new Inventory();
			inventory.setSkuCode("banana");
			inventory.setQuantity(5);
			inventoryRepository.save(inventory);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("apple");
			inventory1.setQuantity(0);
			inventoryRepository.save(inventory1);
		};
	}
}
