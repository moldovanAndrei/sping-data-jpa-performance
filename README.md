# sping-data-jpa-performance


Installation:

- Add the ojdbc6 dependency in one of the following ways:
 A) Uncomment the dependency in the pom.xml file and extract the .zip file from the project resources to your local .m2 repository.
 B) Extract the .zip file from the project resources and add it to your project build path.
 
- Setup a local oracle 11g connection and update the connection data (url, username, password) in application.properties
- Initialize your database with test data by running the CreateDemoData class (scr/main/test com.andrei.jpa.demo)
