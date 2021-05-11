# FluentD with Loki

To use FluentD for parsing logs and sending to Loki, we need to enable the Loki plugin 

```
fluent-gem install fluent-plugin-grafana-loki
```

`fluent.conf` is a sample fluentd configuration file.

Build the docker image - 

```
docker build -t hemantdindi/fluentd-loki:latest . 
docker push hemantdindi/fluentd-loki:latest
```

We shall use this fluentd image to send logs to loki in this application.