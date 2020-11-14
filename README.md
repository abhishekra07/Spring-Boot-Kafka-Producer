# Spring-Boot-Kafka-Producer
 This will demonstrate how to publish message to kafka server topic

## Start zookeeper server
.\bin\windows\zookeeper-server-start.bat  .\config\zookeeper.properties

## Start Kafka Server
.\bin\windows\kafka-server-start.bat .\config\server.properties

## Create topic
.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic firstTopic

## Producer
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic firstTopic

## Consumer
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic firstTopic --from-beginning
