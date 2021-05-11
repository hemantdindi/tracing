
Build the docker image - 

```
cd docker
docker build -t hemantdindi/sb-helloworld:v1 . 
docker push hemantdindi/sb-helloworld:v1
```

Enable endpoints actuator endpoints by adding the following lines to  `application.properties`

Spring Boot Actuator

```
management.endpoints.enabled-by-default=true
```

Install container using helm command

```
helm install sb-helloworld -f ./helloworld-chart/values.yaml ./helloworld-chart/
```

## UnInstall

To uninstall chart that is running use this command:
```
helm uninstall spring-boot-helloworld
```
