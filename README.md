# Video Game API
## Sample JSON Requests
### Users Entity
```json
	1.	Call Type: POST
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
	3.	 Call Type: GET
		Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/users
	4. 	Call Type: GET by ID
		Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/users/1
	5.	Call Type: DELETE
		Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/users/1
		
### Products Entity
	1.	Call Type: POST
		Request URL: http://localhost:8080/products/create/game
		JSON: 
```json
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
	2.	Call Type: POST
		Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/products/create/platform
		JSON: 
```json
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
	3.	Call Type: GET
		Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/products
	4.	Call Type: DELETE
		Request URL: http://videogameapi-dev.us-west-2.elasticbeanstalk.com/products/1
