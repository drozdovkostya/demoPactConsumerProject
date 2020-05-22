# demoPactConsumerProject
DemoPactConsumerProject is a project created for webinar about contract testing.
Here is developed consumer test, that generates pact contract file.

Prerequisites
Java 8
Maven
Docker compose

Docker-compose.yml located in the root of the project.

Command to run docker compose: 
"docker-compose up"

Command to run the test and publish pact contract to pact-broker: 
"mvn clean verify pact:publish -DpactBrokerUrl=http://localhost:80"
