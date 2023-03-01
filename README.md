# PlanetsManager

Application uses PostgreSQL DBMS.
To start the application create datebase called: "planetsManagerDB";
If needed change the port on which db is running; Default set to localhost:5432

IMPORTANT!!!
When starting the app, if there is problem with db driver, please manually delete the postgresql dependency in pom.xml,
then right click on project -> maven -> update project and after that paste dependency back to pom.xml and update project again.

Some strange issue I tried to solve with different options but it is sometimes present.
If you just update project it won't go away, needs to be deleted and then pasted back.

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
