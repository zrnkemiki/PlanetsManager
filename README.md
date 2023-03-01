# PlanetsManager

To start the application create datebase called: "planetsManagerDB";

If needed change the port on which db is running;   
Default port set to localhost:5432;  
Default username: postgres;  
Default password: 1234;  

There is also import.sql file which is used for inital database importing and also for test purposes;  

For testing purposes H2 database is used and the properties are set under src/test/resources/application.properties;

##**IMPORTANT!!!

When starting the app, if there is **problem with database driver**, please manually delete or cut the postgresql dependency in pom.xml,
then right click on project -> maven -> update project and after that paste dependency back to pom.xml and update project again.

This is strange issue and I tried to solve with different options but it is sometimes still present.
If you just update project it help, needs to be deleted and then pasted back.

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>

There is Postman (JSON) collection for REST API testing;
