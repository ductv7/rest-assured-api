REST-ASSURED API + Extent Report V3 + Maven + TestNG + Log4j2

1. How to run

> maven test

2. If you want the report for client which they can access, you can put extent report to folder of Apache server

It should be configured on ExtentManager.java class  

3. Log4j2

- log4j2.xml configuration file should be on src/main/resources
- On pom.xml file, add dependencies log4j-core and log4j-api
- It will write error log into file on folder logs/console.log