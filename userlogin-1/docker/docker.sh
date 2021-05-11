#cp ../target/regapp-0.0.1-SNAPSHOT.jar .
cp ../src/main/resources/application.properties .
docker build -t hemantdindi/regapp:v5 .
docker push hemantdindi/regapp:v5
