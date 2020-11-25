# STUDENT MANAGEMENT SYSTEM
This application is a JAX-RS implementation of JAVA EE. 
It uses Payara 5.2020.5 as server and H2 as temporary database.

##TARGETS
1- CRUD operations should be implemented.

2- All fields except "telephone number" should be provided when a new student is added. 

3- Data about a student must be able to be retrieved with last name as a parameter in the URL.

4- Custom exception should be created.
 
5- No 500 - Internal Server Error may occur

# POST 

__URL: http://localhost:8080/studeman/api/v1/student/new__

Sample data 1:
 ```
 {
    "firstName": "Allison",
    "lastname": "Burgers",
    "email": "Allison.Burgers@email.com",
    "phoneNumber": "070xxxxxxx"
 }
```
Output:
````
{ "email": "Allison.Burgers@email.com",
  "firstName": "Allison",
  "id": 1,
  "lastname": "Burgers",
  "phoneNumber": "070xxxxxxx"
}
````

Sample data 2:

````
 {
     "firstName": "",
     "lastname": "Burgers",
     "email": "Allison.Burgers@email.com",
     "phoneNumber": "070xxxxxxx"
   }

````

Output 2:
````
    Firstname, Lastname and e-mail can not be empty. 
    Please fill all required fields.
````

# GET

__GetOne URL: http://localhost:8080/studeman/api/v1/student/id__

Sample Post Data:
````
{
    "firstName": "Mike",
    "lastname": "Taylor",
    "email": "Mike.Taylor@email.com",
    "phoneNumber": "070xxxxxxx"
  }

````
Output:

````
{
  "email": "Mike.Taylor@email.com",
  "firstName": "Mike",
  "id": 2,
  "lastname": "Taylor",
  "phoneNumber": "070xxxxxxx"
}
````

__GetAll URL: http://localhost:8080/studeman/api/v1/student/getall__

Output:

````
[
  {
    "email": "Allison.Burgers@email.com",
    "firstName": "Allison",
    "id": 1,
    "lastname": "Burgers",
    "phoneNumber": "070xxxxxxx"
  },
  {
    "email": "Mike.Taylor@email.com",
    "firstName": "Mike",
    "id": 2,
    "lastname": "Taylor",
    "phoneNumber": "070xxxxxxx"
  }
]
````

__If no student data recorded yet GetOne and GetAll methods above  will throw exceptions and inform the user as shown below__



GetOne:
````
Student with ID:{id} not found
````
GetAll: 
````
Currently there is no student information recorded in the database
````

## PUT

__Update URL: http://localhost:8080/studeman/api/v1/student/update/1__

Sample update data
````
{ 
  "firstName": "Alyssa",
  "id": 1,
  "lastname": "Burgers",
	 "email": "Alyssa.Burgers@email.com",
  "phoneNumber": "09XXXXXXXX"
}
````


Output
````
[
  {
    "email": "Alyssa.Burgers@email.com",
    "firstName": "Alyssa",
    "id": 1,
    "lastname": "Burgers",
    "phoneNumber": "09XXXXXXXX"
  },
  {
    "email": "Mike.Taylor@email.com",
    "firstName": "Mike",
    "id": 2,
    "lastname": "Taylor",
    "phoneNumber": "070xxxxxxx"
  }
]
````

##DELETE

__Delete URL : http://localhost:8080/studeman/api/v1/student/1__

Output
````
student with id: 1 was successfully removed
````

GetAll Output

````
[
  {
    "email": "Mike.Taylor@email.com",
    "firstName": "Mike",
    "id": 2,
    "lastname": "Taylor",
    "phoneNumber": "070xxxxxxx"
  }
]
````