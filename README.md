# DemoPactConsumerProject
DemoPactConsumerProject is a project created for webinar about contract testing.
Here is developed consumer test, that generates pact contract file.

# Prerequisites
* Java 8
* Maven
* Docker compose
## Getting Started

Docker-compose.yml located in the root project path 

Command to run docker compose: 
* run `docker-compose up`

Command to run the test and publish pact contract to pact-broker: 
* run `mvn clean verify pact:publish -DpactBrokerUrl=http://localhost:80`
