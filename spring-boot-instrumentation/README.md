
### Running the Application

```
java -javaagent:/app/opentelemetry-javaagent-all.jar -javaagent:/app/jmx_prometheus_javaagent-0.15.0.jar=9104:/app/jmx-config.yaml -Dotel.trace.exporter=jaeger -Dotel.exporter.jaeger.endpoint=tempo:14250 -Dotel.resource.attributes=service.name=spring-boot-instrumentation -Dotel.javaagent.debug=false -Dotel.metrics.exporter=none -jar /app/spring-boot-instrumentation-0.0.1-SNAPSHOT.jar --spring.config.location=/app/application.properties
```


We are passing two additional jars

- opentelemetry-javaagent-all.jar - To collect spans and traces using the OpenTelemetry API

  The property otel.exporter.jaeger.endpoint has to be the service endpoint of tempo

- jmx_prometheus_javaagent-0.15.0.jar - To collect Prometheus metrics from the application.

  Metrics are exposed on 9104 port

### Build the Docker image

```
cd docker
./docker.sh
```


### Running on k8s

```
cd k8s
k create -f .
```

To ensure the JMX metrics are scrapped by prometheus, we have to create a ServiceMonitor

```
apiVersion: monitoring.coreos.com/v1
kind: ServiceMonitor
metadata:
  name: traceapp-svc-monitor
  labels:
    release: monitoring
spec:
  selector:
    matchLabels:
      apps: sb-trace
  endpoints:
  - port: metrics-port
```
