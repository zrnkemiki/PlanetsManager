# PlanetsManager

To start the application create datebase called: "planetsManagerDB";

If needed change the port on which db is running;   
Default port set to localhost:5432;  
Default username: postgres;  
Default password: 1234;  

There is also import.sql file which is used for inital database importing and also for test purposes;  

For testing purposes H2 database is used and the properties are set under src/test/resources/application.properties;

##**IMPORTANT!!!**##

When starting the app, if you encounter **"Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
Reason: Failed to determine a suitable driver class"**, please remove the postgresql dependency in pom.xml,
then right click on project -> maven -> update project and after that paste dependency back to pom.xml and update project again.

I tried solving this issue with many different options but it is present sometimes (on the first app start) and in Eclipse IDE, when imported to InteliJ everything works fine.
If you just update project it won't help, needs to be removed, updated and then pasted back and updated again.

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>

There is Postman (JSON) collection for REST API testing;
