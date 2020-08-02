#!/bin/bash

echo "Setting up Docker" &
wait
docker-compose up -d

wait
echo "Executing Tests" &
wait
docker run  --network="host" day2demoim mvn -f /home/DockerTestFramework/pom.xml clean test
wait

echo "Tests Executed" &
wait

echo "Stopping Container" &
docker-compose stop
wait

echo "Cleaning Memory" &
docker container prune -f
wait



