# Selenium Automated Testing on Alaska Airline official website - www.alaskaair.com

The project tests the sign-in process, verifies the account information and performs searching and booking flight tickets. It's developed using Selenium WebDriver, testing framework TestNG, Maven to manage dependencies, log4j to generate logs, Jenkins to build tests and publish test results.

*Demo*:  
1. First testing tests searching and booking 3 adult flight tickets from San Jose to Seattle on 01/01/2018.  

![demo](./demo/demo_test1.gif)

2. Second testing tests the sign-in functionality and verifies the account's mileage plan number.  
   At the end, the terminal displays all two testings are successful.

![demo](./demo/demo_test2.gif)

## Install

Clone the repository.
```bash
$ git clone https://github.com/xinjoy/selenium_airlinetest.git
```

## Run
Use Maven to build and run the tests
```bash
$ cd selenium_airlinetest
$ mvn test
```
