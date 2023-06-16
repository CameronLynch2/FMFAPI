Welcome to the pet storage API by Cameron Lynch!

This is a basic example API where you can create, update, store, delete, and retrieve pets from a web connection. The API uses local storage to store the pets,
and 3 basic functions to perform its tasks. 

Functions:

1. Add/Update
		localhost:port/updatepet?id=LONG&name=STRING&breed=STRING&age=INT
		
		Adds to the pet registry or updates and existing pet in the system
		
		id ==> A long identifying number > 0
		name ==> A string of the pet's name
		breed ==> A string of the animal's breed/pecies
		age ==> An int of the animal's age
		
		returns:
			-1 ==> failed
			1  ==> Updated a pet successfully
			2  ==> Added a pet successfully
			
2. Delete
		localhost:port/delete?id=LONG
		
		Deletes a pet from the registry
		
		id ==> A long identifying number > 0
		
		returns:
			-1 ==> failed
			1  ==> Deleted a pet successfully
			
3. Get
		localhost:port/getpetbyid?id=LONG
		
		Returns a pet from the registry
		
		id ==> A long identifying number > 0
		
		returns:
			{-1, "", "", 0} ==> Failed to find the pet
			{long id, String name, String breed, int age} ==> Successfully found the pet
			
Setting up the API for usage:
	Start up the API
	Identify the hosted local port containing the process
	Use a browser to run the URL requests as shown above

Example test:
	localhost:8080/updatepet?id=1&name=billy&breed=pug&age=5
	localhost:8080/updatepet?id=2&name=billy&breed=pug&age=5
	localhost:8080/updatepet?id=2&name=bobby&breed=pug&age=8
	localhost:8080/getpetbyid?id=1
	localhost:8080/getpetbyid?id=2
	localhost:8080/delete?id=1
	localhost:8080/getpetbyid?id=1
	
	
