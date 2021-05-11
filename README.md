# A demo to implement monitoring and tracing on a k8s environment

#### Set the kubeconfig

-

    export KUBECONFIG=/Users/hemantdindi/Downloads/hemantdindi-kubeconfig.yaml

#### Ensure metrics server is installed on the cluster. Kubernetes Metrics Server

-

  ```
  k apply -f https://github.com/kubernetes-sigs/metrics-server/releases/download/v0.4.4/components.yaml
  ```

#### Tools Used -

- Prometheus
- Grafana
- Alertmanager
- Loki
- Tempo
- Springboot v2.4.5
- Helm

#### Instructions

- [Monitoring](./monitoring/README.md)
- [Loki](./monitoring/loki.md)
- [Tempo](./monitoring/tempo.md)
- [FluentD](./monitoring/fluentd-loki/README.md)