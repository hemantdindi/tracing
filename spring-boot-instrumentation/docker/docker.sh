#cp ../target/regapp-0.0.1-SNAPSHOT.jar .
#cp ../src/main/resources/application.properties .
docker build -t hemantdindi/sb-instrumentation:v2 .
docker push hemantdindi/sb-instrumentation:v2
