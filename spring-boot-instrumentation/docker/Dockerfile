FROM openjdk:8-jdk-slim
RUN mkdir -p /app \
	&& groupadd -g 1001 webapp && useradd -u 1001 -g 1001 webapp
COPY application.properties jmx-config.yaml jmx_prometheus_javaagent-0.15.0.jar opentelemetry-javaagent-all.jar spring-boot-instrumentation-0.0.1-SNAPSHOT.jar /app/
RUN chown -R webapp:webapp /app && chmod -R 755 /app
USER webapp
CMD ["java", "-javaagent:/app/opentelemetry-javaagent-all.jar", "-javaagent:/app/jmx_prometheus_javaagent-0.15.0.jar=9104:/app/jmx-config.yaml", "-Dotel.trace.exporter=jaeger", "-Dotel.exporter.jaeger.endpoint=tempo:14250","-Dotel.resource.attributes=service.name=spring-boot-instrumentation", "-Dotel.javaagent.debug=false","-Dotel.metrics.exporter=none", "-jar", "/app/spring-boot-instrumentation-0.0.1-SNAPSHOT.jar", "--spring.config.location=/app/application.properties"]
