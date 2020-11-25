# STUDENT MANAGEMENT SYSTEM
This application is a JAX-RS implementation of JAVA EE. 
It uses Payara 5.2020.5 as server and H2 as temporary database.

##STUDENT


# GET


__GetAll URL: http://localhost:8080/studeman/api/v1/student/getall__

Output:

````
[
  {
    "email": "Elon.Tesla@tesla.com",
    "firstName": "Elon",
    "id": 1,
    "lastname": "Tesla",
    "phoneNumber": "000-000001"
  },
  {
    "email": "Hillary.Mail@gmail.com",
    "firstName": "Hillary",
    "id": 3,
    "lastname": "Mail",
    "phoneNumber": "000-000002"
  },
  {
    "email": "Angeli.Pitt@mrmrssimith.com",
    "firstName": "Angelina",
    "id": 5,
    "lastname": "Pitt",
    "phoneNumber": "000-000007"
  },
  {
    "email": "Leonardo.Oscar@revenant.com",
    "firstName": "Leonardo",
    "id": 7,
    "lastname": "Oscar",
    "phoneNumber": "000-000003"
  },
  {
    "email": "John.Envoy@enviroment.com",
    "firstName": "John",
    "id": 8,
    "lastname": "Envoy",
    "phoneNumber": "000-000008"
  },
  {
    "email": "Trump.Golf@pennsylvania.com",
    "firstName": "Trump",
    "id": 9,
    "lastname": "Golf",
    "phoneNumber": "000-000004"
  },
  {
    "email": "Joe.Winner@vithus.com",
    "firstName": "Joe",
    "id": 11,
    "lastname": "Winner",
    "phoneNumber": "000-000006"
  },
  {
    "email": "Maradona.Godshand@fifa.com",
    "firstName": "Maradona",
    "id": 12,
    "lastname": "Godshand",
    "phoneNumber": "000-000005"
  }
]
````

__GetOne URL: http://localhost:8080/studeman/api/v1/student/1__


Output:

````
{
  "email": "Elon.Tesla@tesla.com",
  "firstName": "Elon",
  "id": 1,
  "lastname": "Tesla",
  "phoneNumber": "000-000001"
}
````


__If no student data recorded yet GetOne and GetAll methods above  will throw exceptions and inform the user as shown below__



GetOne URL: http://localhost:8080/studeman/api/v1/student/10__
````
Student with ID:{id} not found
````
GetAll: After using delete method 
````
Currently there is no student information recorded in the database
````

__Get student by lastname URL: http://localhost:8080/studeman/api/v1/student/getbyname_np/golf__



Output
````
[
  {
    "email": "Trump.Golf@pennsylvania.com",
    "firstName": "Trump",
    "id": 9,
    "lastname": "Golf",
    "phoneNumber": "000-000004"
  }
]

````





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

##TEACHER


# GET


__GetAll URL: http://localhost:8080/studeman/api/v1/teacher/getall__

Output:

````
[
  {
    "email": "Tom.Hanks@academy.com",
    "firstName": "Tom",
    "id": 14,
    "lastName": "Hanks",
    "phoneNumber": "100-000000"
  },
  {
    "email": "Madeleine.Albright@state.gov",
    "firstName": "Madeleine",
    "id": 15,
    "lastName": "Albright",
    "phoneNumber": "200-000000"
  },
  {
    "email": "Barack.Obama@potus.gov",
    "firstName": "Barack",
    "id": 16,
    "lastName": "Obama",
    "phoneNumber": "300-000000"
  },
  {
    "email": "Pele@fifa.com",
    "firstName": "Pele",
    "id": 17,
    "lastName": "Pele",
    "phoneNumber": "400-000000"
  }
]
````

__GetOne URL: http://localhost:8080/studeman/api/v1/teacher/14__


Output:

````
{
  "email": "Tom.Hanks@academy.com",
  "firstName": "Tom",
  "id": 14,
  "lastName": "Hanks",
  "phoneNumber": "100-000000"
}
````


__If no teacher data recorded yet GetOne and GetAll methods above  will throw exceptions and inform the user as shown below__



GetOne URL: http://localhost:8080/studeman/api/v1/teacher/1__
````
Teacher with ID:1 not found
````
GetAll: After using delete method 
````
Currently there is no teacher information recorded in the database
````


__Get Teacher by lastname URL: http://localhost:8080/studeman/api/v1/teacher/getbyname_np/Hanks__



Output
````
[
  {
    "email": "Tom.Hanks@academy.com",
    "firstName": "Tom",
    "id": 14,
    "lastName": "Hanks",
    "phoneNumber": "100-000000"
  }
]
````



# POST 

__URL: http://localhost:8080/studeman/api/v1/teacher/new__

Sample data 1:
 ```
 {
    "firstName": "Jay Jay",
    "lastName": "Okocha",
    "email": "jayjay.okocha@email.com",
    "phoneNumber": "070xxxxxxx"
 }

```
Output:
````
{
  "email": "jayjay.okocha@email.com",
  "firstName": "Jay Jay",
  "id": 18,
  "lastName": "Okocha",
  "phoneNumber": "070xxxxxxx"
}
````

Sample data 2 missing data:

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


## PUT

__Update URL: http://localhost:8080/studeman/api/v1/teacher/update/1__

Sample update data
````
{
	"email": "jayjay.okocha@email.com",
	"firstName": "Jay Jay",
	"id": 18,
	"lastName": "Okocha",
	"phoneNumber": "070000000"
}
````


Output
````
{
  "email": "jayjay.okocha@email.com",
  "firstName": "Jay Jay",
  "id": 18,
  "lastName": "Okocha",
  "phoneNumber": "070000000"
}
````

##DELETE

__Delete URL : http://localhost:8080/studeman/api/v1/teacher/18__

Output
````
teacher with id: 18 was successfully removed
````



##SUBJECT


# GET


__Get all subjects  URL: http://localhost:8080/studeman/api/v1/subject/getSubjectMatters__

Output
````
[
  {
    "email": "Madeleine.Albright@state.gov",
    "firstName": "Madeleine",
    "id": 15,
    "lastName": "Albright",
    "phoneNumber": "200-000000"
  }
]
````


__Get all Students and Teachers with Subject information URL: http://localhost:8080/studeman/api/v1/subject/getall__

Output:

````
[
  {
    "id": 2,
    "students": [
      {
        "email": "Elon.Tesla@tesla.com",
        "firstName": "Elon",
        "id": 1,
        "lastname": "Tesla",
        "phoneNumber": "000-000001"
      }
    ],
    "subjectMatter": "Space"
  },
  {
    "id": 4,
    "students": [
      {
        "email": "Angeli.Pitt@mrmrssimith.com",
        "firstName": "Angelina",
        "id": 5,
        "lastname": "Pitt",
        "phoneNumber": "000-000007"
      },
      {
        "email": "Hillary.Mail@gmail.com",
        "firstName": "Hillary",
        "id": 3,
        "lastname": "Mail",
        "phoneNumber": "000-000002"
      },
      {
        "email": "John.Envoy@enviroment.com",
        "firstName": "John",
        "id": 8,
        "lastname": "Envoy",
        "phoneNumber": "000-000008"
      }
    ],
    "subjectMatter": "Diplomacy",
    "teacher": {
      "email": "Madeleine.Albright@state.gov",
      "firstName": "Madeleine",
      "id": 15,
      "lastName": "Albright",
      "phoneNumber": "200-000000"
    }
  },
  {
    "id": 6,
    "students": [
      {
        "email": "Angeli.Pitt@mrmrssimith.com",
        "firstName": "Angelina",
        "id": 5,
        "lastname": "Pitt",
        "phoneNumber": "000-000007"
      },
      {
        "email": "Leonardo.Oscar@revenant.com",
        "firstName": "Leonardo",
        "id": 7,
        "lastname": "Oscar",
        "phoneNumber": "000-000003"
      }
    ],
    "subjectMatter": "Cinema",
    "teacher": {
      "email": "Tom.Hanks@academy.com",
      "firstName": "Tom",
      "id": 14,
      "lastName": "Hanks",
      "phoneNumber": "100-000000"
    }
  },
  {
    "id": 10,
    "students": [
      {
        "email": "Joe.Winner@vithus.com",
        "firstName": "Joe",
        "id": 11,
        "lastname": "Winner",
        "phoneNumber": "000-000006"
      },
      {
        "email": "Trump.Golf@pennsylvania.com",
        "firstName": "Trump",
        "id": 9,
        "lastname": "Golf",
        "phoneNumber": "000-000004"
      }
    ],
    "subjectMatter": "Governance",
    "teacher": {
      "email": "Barack.Obama@potus.gov",
      "firstName": "Barack",
      "id": 16,
      "lastName": "Obama",
      "phoneNumber": "300-000000"
    }
  },
  {
    "id": 13,
    "students": [
      {
        "email": "Maradona.Godshand@fifa.com",
        "firstName": "Maradona",
        "id": 12,
        "lastname": "Godshand",
        "phoneNumber": "000-000005"
      }
    ],
    "subjectMatter": "Football",
    "teacher": {
      "email": "Pele@fifa.com",
      "firstName": "Pele",
      "id": 17,
      "lastName": "Pele",
      "phoneNumber": "400-000000"
    }
  }
]
````

__GetStudents by subject  URL: http://localhost:8080/studeman/api/v1/subject/getStudents/Diplomacy__

Output:

````
[
  {
    "email": "Hillary.Mail@gmail.com",
    "firstName": "Hillary",
    "id": 3,
    "lastname": "Mail",
    "phoneNumber": "000-000002"
  },
  {
    "email": "Angeli.Pitt@mrmrssimith.com",
    "firstName": "Angelina",
    "id": 6,
    "lastname": "Pitt",
    "phoneNumber": "000-000007"
  },
  {
    "email": "John.Envoy@enviroment.com",
    "firstName": "John",
    "id": 5,
    "lastname": "Envoy",
    "phoneNumber": "000-000008"
  }
]
````


__GetTeachers by subject  URL: http://localhost:8080/studeman/api/v1/subject/getTeachers/Diplomacy__
Output:

Output
````
[
  {
    "email": "Madeleine.Albright@state.gov",
    "firstName": "Madeleine",
    "id": 15,
    "lastName": "Albright",
    "phoneNumber": "200-000000"
  }
]
````


__Get both Teachers and Students by subject  URL: http://localhost:8080/studeman/api/v1/subject/getAllBySubject/diplomacy__
Output:

 ```
[
  {
    "id": 4,
    "students": [
      {
        "email": "Angeli.Pitt@mrmrssimith.com",
        "firstName": "Angelina",
        "id": 6,
        "lastname": "Pitt",
        "phoneNumber": "000-000007"
      },
      {
        "email": "Hillary.Mail@gmail.com",
        "firstName": "Hillary",
        "id": 3,
        "lastname": "Mail",
        "phoneNumber": "000-000002"
      },
      {
        "email": "John.Envoy@enviroment.com",
        "firstName": "John",
        "id": 5,
        "lastname": "Envoy",
        "phoneNumber": "000-000008"
      }
    ],
    "subjectMatter": "Diplomacy",
    "teacher": {
      "email": "Madeleine.Albright@state.gov",
      "firstName": "Madeleine",
      "id": 15,
      "lastName": "Albright",
      "phoneNumber": "200-000000"
    }
  }
]

```



__Get 

# POST 

__URL: http://localhost:8080/studeman/api/v1/subject/new__

Sample data :
 ```
{

  "subjectMatter": "Medicine"
}

```
Output:
````
{
  "id": 18,
  "students": [],
  "subjectMatter": "Medicine"
}
````


