# Spring-boot service

Build an Image:
mvn package docker:build

Run App:
docker run -p 9091:9090 springexp-app/springexp

Run App with dev Profile:
java -jar target/springexp-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev

