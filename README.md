# sping-data-jpa-performance


Installation:

- Add the ojdbc6 jar to your local .m2 repository (found in project resources).
- Setup a local oracle 11g connection and update the connection data (url, username, password) in application.properties.
- Mvn install.
- Initialize your database with test data by running the CreateDemoData class (scr/main/test com.andrei.jpa.demo).

TODO:
- add example for jdbc_batch_size with order inserts/updates.
- exemplify batch inserts with allocationSize 1/100/1000 on id sequence generation.
