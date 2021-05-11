FROM openjdk:8-jdk-slim
RUN mkdir -p /app/jar /app/config /var/log/app/ \
	&& groupadd -g 1001 webapp && useradd -u 1001 -g 1001 webapp
COPY regapp-0.0.1-SNAPSHOT.jar jmx_prometheus_javaagent-0.15.0.jar opentelemetry-javaagent-all.jar /app/jar/
COPY application.properties jmx-config.yaml /app/config/
RUN chown -R webapp:webapp /app && chmod -R 755 /app
USER webapp
ENTRYPOINT ["java", "-javaagent:/app/jar/jmx_prometheus_javaagent-0.15.0.jar=9104:/app/config/jmx-config.yaml", "-jar", "/app/jar/regapp-0.0.1-SNAPSHOT.jar", "--spring.config.location=/app/config/application.properties"]
EXPOSE 7080


#https://repo1.maven.org/maven2/io/prometheus/jmx/jmx_prometheus_javaagent/0.15.0/jmx_prometheus_javaagent-0.15.0.jar
