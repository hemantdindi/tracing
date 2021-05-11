FROM openjdk:8-jdk-slim
RUN mkdir -p /app \
	&& groupadd -g 1001 webapp && useradd -u 1001 -g 1001 webapp
COPY ./target/com.hemant.helloworld-1.0-SNAPSHOT.jar /app/helloworld.jar
COPY jmx_prometheus_javaagent-0.15.0.jar /app/
COPY jmx-config.yaml /app/
RUN chown -R webapp:webapp /app && chmod -R 755 /app
USER webapp
CMD ["java", "-javaagent:/app/jmx_prometheus_javaagent-0.15.0.jar=9104:/app/jmx-config.yaml", "-jar", "-Dspring.profiles.active=default", "/app/helloworld.jar"]
