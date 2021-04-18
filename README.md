
# Video Game API
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
	3. 	Call Type: GET by ID
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
 3. Call Type: GET
	Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/products
 4. Call Type: GET by ID
	Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/products/1
 5. Call Type: DELETE
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
4. Call Type: GET by ID 
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