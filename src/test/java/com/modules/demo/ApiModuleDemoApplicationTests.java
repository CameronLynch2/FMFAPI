package com.modules.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiModuleDemoApplicationTests {
	@Autowired
    private PetController cont;
	
	@Test
	void contextLoads() {
		assertThat(cont).isNotNull();
		assert(cont.defaultPage() == "Welcome to the pet storage!");
	}
	
	@Test
	void testAdd() {
		assert(cont.addUpdatePet(1, "Bill", "Pug", 5) == 2);
		assert(cont.addUpdatePet(2, "Bill", "Pug", 5) == 2);
		assert(cont.addUpdatePet(2, "Bobby", "Pug", 7) == 1);
		assert(cont.addUpdatePet(-4, "", "", 0) == -1);
	}
	
	@Test
	void testDelete() {
		assert(cont.deletePet(1) == 1);
		assert(cont.deletePet(5) == -1);
	}
	
	@Test
	void testGet() {
		
	}

}
