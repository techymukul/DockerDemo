FROM maven:3.6.0-jdk-8-alpine


# copying src of your framework
COPY src /home/DockerTestFramework/src

# copying pom.xml of your framework
COPY pom.xml /home/DockerTestFramework

# copying testng.xml of your framework
COPY testng.xml /home/DockerTestFramework

RUN mvn -f /home/DockerTestFramework/pom.xml dependency:go-offline -B

#Running the actual command
RUN mvn -f /home/DockerTestFramework/pom.xml install -DskipTests=true