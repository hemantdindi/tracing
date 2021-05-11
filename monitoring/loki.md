## Installation of Loki

- Install Loki as a standalone service. Reuse the Grafana that was installed above

    ```
    helm repo add grafana https://grafana.github.io/helm-charts
    helm upgrade --install loki grafana/loki-stack --set grafana.enabled=false
    ```

    When we add Loki as source in Grafana, Also update `Derived fields` as below :

    | Field | Value|
    |---|---|
    | Name |TraceID |
    | Regex| traceID=(\w+)|
    | Query|$\{__value.raw\} |
    | Internal Link| Enabled - Set as Tempo|
    
<br />
<hr /> <br />

![Loki and Tempo ](./images/loki-tempo.png)