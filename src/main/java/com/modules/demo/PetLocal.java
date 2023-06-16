package com.modules.demo;

public class PetLocal {
	private final long id;
	private String name;
	private String breed;
	private int age;
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param breed
	 * @param age
	 */
	public PetLocal(long id, String name, String breed, int age) {
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.age = age;
	}
	
	/**
	 * 
	 * @param old
	 */
	public PetLocal(PetLocal old) {
		this.id = old.id;
		this.name = old.name;
		this.breed = old.breed;
		this.age = old.age;
	}
	
	/**
	 * 
	 * @return
	 */
	public Pet makePet() {
		return new Pet(this.id, this.name, this.breed, this.age);
	}

	/**
	 * 
	 * @param id2
	 * @param name2
	 * @param breed2
	 * @param age2
	 */
	public void updatePet(long id2, String name2, String breed2, int age2) {
		this.name = name2;
		this.breed = breed2;
		this.age = age2;
	}
	
}
