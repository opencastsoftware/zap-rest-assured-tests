# Opencast Software interview pairing session for Acceptance test with REST assured/Java 

# Requirements for running this repository:

* Java 1.8
* Maven 3.9.5
* REST Assured 5.3.2
* TestNG

## Overview On Framework

* Api Testing Framework is built using REST Assured which is a java library for testing RESTful web services.
* It supports POST, GET, PUT, DELETE and PATCH requests.

## Maven dependencies used in the Framework

* [testng](https://mvnrepository.com/artifact/org.testng/testng)
* [rest-assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured)
* [json-simple](https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple)

## Run maven
``` bash
mvn clean install
```
## Run application through the terminal
``` bash
mvn test
```
# Setup instructions

___You can find setup instructions inside [setup.md](./setup.md). Please finish the setup before interview.___ 

# During your interview you will be asked to action the following:
***Do not complete these before the interview, we will guide you through these.***

```
Scenario 1: Verify 201 status code using POST.
Scenario 2: Verify 400 status code and error message response(Every employee has a role in the company) using POST.
Scenario 3: GET employee details using query parameter surname, verify status code and Response JSON.
Scenario 4: DEBUG - GET all employee details and verify status code 200.
```
