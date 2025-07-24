# Opencast Software Zap security tests integration with REST assured/Java 

# Requirements for running this repository:

* Java 11
* Maven 3.x
* OWASP ZAP (running as a proxy)


## Overview On Framework

* Java-based API test automation framework using Maven, Rest-Assured, Cucumber which integrates with OWASP ZAP for security testing via proxy.

## Maven dependencies used in the Framework

* [cucumber-java](https://mvnrepository.com/artifact/io.cucumber/cucumber-java)
* [rest-assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured)
* [testng](https://mvnrepository.com/artifact/org.testng/testng)

## Run tests with ZAP startup script

To start OWASP ZAP and run the tests automatically, execute:

```bash
./start-zap-and-run.sh
```

This script will launch ZAP as a proxy, execute your test suite and then stops ZAP.
Make sure the script has execute permissions:

chmod +x start-zap-and-run.sh

## Zap vulnerability report
After the tests complete, a zap-report.html file is generated with the security test results.

___You can find setup instructions inside [setup.md](./setup.md).___ 
