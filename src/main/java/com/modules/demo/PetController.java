package com.modules.demo;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {
	private final AtomicLong counter = new AtomicLong();
	private HashMap<Long, PetLocal> pets = new HashMap<Long, PetLocal>();
	
	
	@GetMapping("/")
	public String defaultPage() {
		return "Welcome to the pet storage!";
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getpetbyid")
	public Pet getPet(@RequestParam(value = "id", defaultValue = "0") long id) {
		if(id <= 0) {
			return new Pet(-1, "", "", 0); // Default return
		} else if(pets.get(id) != null){
			return (pets.get(id).makePet()); // Return proper pet (copy of)
		} else {
			return new Pet(-1, "", "", 0);
		}
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param breed
	 * @param age
	 * @requires id > 0
	 */
	@RequestMapping(value = "/updatepet", method = {RequestMethod.GET, RequestMethod.POST})
	public int addUpdatePet(@RequestParam(value = "id", defaultValue = "-1") long id, @RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "breed", defaultValue = "") String breed, @RequestParam(value = "age", defaultValue = "0") int age) {
		
		if(id <= 0) {
			System.out.println("Invalid ID... id = " + id + "... ID must be > 0");
			return -1;
		}
		
		if(pets.get(id) != null) {
			// Update Pet
			PetLocal currentPet = pets.get(id);
			currentPet.updatePet(id, name, breed, age);
			System.out.println("Updated Pet... ID = " + id + "... Location = " + pets.get(id));
			
			return 1;
		} else {
			// Add Pet
			pets.put(id, new PetLocal(id, name, breed, age));
			System.out.println("Added Pet... ID = " + id + "... Location = " + pets.get(id));
			
			return 2;
		}
		
		
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public int deletePet(@RequestParam(value = "id", defaultValue = "-1") long id) {
		System.out.println("Deleting Pet... ID = " + id + "... Location = " + pets.get(id));
		if(pets.get(id) != null) {
			pets.remove(id);
			System.out.println("Deleted Pet... ID = " + id);
			return 1;
		} else {
			System.out.println("Failed... ID = " + id);
			return -1;
		}
	}
}