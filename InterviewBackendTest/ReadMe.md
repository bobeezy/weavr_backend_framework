# QA Engineer test

### This is a sample project to test APIs using JUnit and RestAssured. In this project you will find the configuration required to write tests for a number of endpoints by Go Rest (https://gorest.co.in/), as well as a sample test class to start with.

##### Requirements:

- Using the already implemented create user endpoint, write a number of tests to cover the functionality of this endpoint
- Implement whatever is required to write tests for the update user endpoint

###### The information required to perform those tasks can be found here -> https://gorest.co.in/. Feel free to update the project in any way you see fit.

---

## PRE-REQUISITE ##

IntelliJ IDE, Java(version 11.0.9), Maven, JDK.

## TOOLS USED ##

IntelliJ IDE, Java(version 11.0.9), Maven(3.8), Allure Report, JUnit(version 5).

---

## GENERATE ALLURE REPORT on Mac ##
Reference: https://docs.qameta.io/allure/

1. Execute a test

2. From the terminal, navigate to the project root:

   e.g., $ cd ~/Documents/Projects/Java/InterviewBackendTest

3. Execute the terminal command:

   a.1. Generate allure report :

        $ allure generate allure-results --clean -o allure-report

   a.2. wait for output:

   'Report successfully generated to allure-report'


    a.3. View report (report will open automatically)
    
        $ allure serve allure-results

    //OR
		
	  b.1. Generate allure report : 
   
        $ allure generate allure-results --clean -o allure-report


b.2. wait for output:

'Report successfully generated to allure-report'


b.3. Navigate to '/allure-report/index.html' in the project, then open index.html with any browser

---

## APPLICATION LOGS ##

After each test execution, we can access the logs in file:
InterviewBackendTest/application-yyyyMMdd.log

---
