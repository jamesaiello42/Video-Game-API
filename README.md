# Promineo Tech Final Project - Video Game API
## Short Description of Project
The Video Game API is an e-commerce backend where users can be created. Users can authenticate (log in) through the backend. Users can place orders to buy products and orders can be removed from the database. Products such as video games and video platforms (consoles) can be added to the database. Employees can be created and deleted. Certain fields can be updated. The PUT JSON calls show what can be updated in the database.

## Installation
Type the following to bring a copy of the project to your local computer:
```bash
git clone https://github.com/jamesaiello42/Video-Game-API.git
```
You will need have MYSQL installed on your computer and to have at least Java 8 installed on your computer.

You will need to download Spring Tools from https://spring.io/tools

You will also need to run this statement in MYSQL:
```sql
create database video_games;
```
Open Spring Tools application on your computer and execute the application.

Please let me know if you have questions the setup.

## Sample JSON Requests
### Users Entity
```json
	1.	
		Call Type: POST
		Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/users/register
		JSON: 
		{
			"username": "jaiello",
			"email": "test@example.com",
			"firstName": "james",
			"lastName": "aiello",
			"password": "test"
		}
```
```json
	2.	
		Call Type: POST
		Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/users/login
		JSON: 

		{
			"username": "jaiello",
			"password": "test"
		}
```
	3.	Call Type: GET
		Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/users
	4. 	Call Type: GET by ID
		Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/users/1
	5.	Call Type: DELETE
		Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/users/1
		
### Products Entity
```json
	1.	
		Call Type: POST
		Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/products/create/game
		JSON: 
		{
			"upc": "1",
			"price": 60.0,
			"numberInStock": 123,
			"games": {
				"name": "GTA 5",
				"releaseDate": "2013-09-17"
			}
		}
```
```json
	2.	
		Call Type: POST
		Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/products/create/platform
		JSON: 
		{
			"upc": "2",
			"price": 399.0,
			"numberInStock": 123,
			"platforms": {
				"name": "PS5",
				"vendor": "Sony",
				"releaseDate": "2020-11-12"
			}
		}
```
```
	3.	Call Type: GET
		Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/products
	4.	Call Type: GET by ID
		Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/products/1
	5.	Call Type: DELETE
		Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/products/1
```
### Orders Entity
```json
1. 
	Call Type: POST
	Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/users/1/orders/createOrder
	{
		"products": [
			{"id": 1},
			{"id": 2}
		]
	}
```
```
2.	Call Type: DELETE 
	Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/users/1/orders/4
```
### Employees Entity
```json
1. 
	Call Type: POST
	Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/employees/create
	JSON:
	{
	    "firstName": "Billy",
	    "lastName": "Bob",
	    "role": "Software Developer",
	    "salary": 100000,
	    "username": "billybob1",
	    "email": "test@videogames.com",
	    "password": "reallyStrongPassword",
	    "hireDate": "2019-12-12"
	}
```
```json
2.	Call Type: PUT
	Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/employees/create
	JSON:
	{
		"hireDate": "2020-12-22",
		"salary": 250000.0,
		"role": "Senior Software Developer"
	}
```
```
3.	Call Type: GET 
	Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/employees
4.	Call Type: GET by ID 
	Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/employees/2
4.	Call Type: GET by ID 
	Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/employees/2
```
### Games Entity
```json
1. 
	Call Type: POST
	Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/games/1/assignPlatform/
	JSON:
	[
		{"id": 2},
		{"id": 3}
	]
```
```json
2.	
	Call Type: PUT
	Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/games/4
	JSON:
	{
		"name": "GTA III",
		"releaseDate": "2001-10-22"
	}
```
### Platform Entity
```json
1.	
	Call Type: PUT
	Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/games/4
	JSON:
	{
		"name": "PS4",
		"releaseDate": "2013-11-15",
		"vendor": "Sony"
	}
```

## Screenshots of API Running
![Create User](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/users_create.jpg)

![Login User](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/users_login.jpg)

![Upldate Platform](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/platforms_update.jpg)

![Create Platform](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/platform_create.jpg)

![Order Deletion](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/order_delete.jpg)

![List One User](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/list_one_user.jpg)

![List One Product](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/list_one_product.jpg)

![List All Users](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/list_all_users.jpg)

![List All Products](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/list_all_products.jpg)

![List One Employee](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/get_one_employee.jpg)

![List All Employees](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/get_all_employees.jpg)

![Update Game](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/game_update.jpg)

![Create Game](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/game_create.jpg)

![Update Employee](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/employee_update.jpg)

![Delete Employee](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/employee_delete.jpg)

![Delete User](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/delete_user.jpg)

![Delete Product](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/delete_product.jpg)
 
![Create Order](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/create_order.jpg)

![Create Employee](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/create_employee.jpg)

![Add Platforms to Games](https://github.com/jamesaiello42/Video-Game-API/blob/main/screenshots/add_games_to_platform.jpg)
