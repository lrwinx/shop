mvn clean package

cd eureka-server
mvn docker:build

cd ../config-server
mvn docker:build

cd ../api-gateway
mvn docker:build

cd ../zipkinserver
mvn docker:build


cd ../user-service/user-service-core
mvn docker:build

cd ../../score-service/score-service-core
mvn docker:build


docker run -d -p 8501:8501 eureka-server:0.0.1-SNAPSHOT
docker run -d -p 8888:8888 config-server:0.0.1-SNAPSHOT
docker run -d -p 9411:9411 zipkin-server:0.0.1-SNAPSHOT
docker run -d -p 9999:9999 api-gateway:0.0.1-SNAPSHOT

docker run -d -p 8001:8001 user-service-core:0.0.1-SNAPSHOT
docker run -d -p 8002:8002 score-service-core:0.0.1-SNAPSHOT
