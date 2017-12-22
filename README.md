_**GRAPHQL**_

POST query  => http://localhost:8080/query

{
	allPeople {
		firstName
		age
	}
}

Output:{
           "allPeople": [
               {
                   "firstName": "Adam",
                   "age": 30
               },
               {
                   "firstName": "Bella",
                   "age": 12
               }
           ]
       }
       
POST query  => http://localhost:8080/query

{
person(id:"2"){
firstName
age
}
}

Output:{
           "person": {
               "firstName": "Bella",
               "age": 12
           }
       }
 

_**REST**_  
    
GET query  => http://localhost:8080/persons

Output:[
           {
               "id": "1",
               "firstName": "Adam",
               "lastName": "Lim",
               "age": 30
           },
           {
               "id": "2",
               "firstName": "Bella",
               "lastName": "Ten",
               "age": 12
           }
       ]
       

