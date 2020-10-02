# kafka-mq-java-app

## Team Lead

- Anil Bomma [https://github.com/anil-bomma](https://github.com/anil-bomma)

## Team Members

- Sravani Jaidi [https://github.com/Sravani537520](https://github.com/Sravani537520)
- Jack Beaver [https://github.com/JackWBeaver](https://github.com/JackWBeaver)
- Priyanka Bodapati [https://github.com/pinky407](https://github.com/pinky407)
- Sushmita Rudra [https://github.com/Sushmita-Rudra](https://github.com/Sushmita-Rudra)

## Prerequisities

- OpenJDK or JDK (8 or up)
- Apache Zookeeper, installed and working
- Apache Kafka, installed and working

## Start Zookeeper Service

Start Zookeeper service as you did previously.

## Start Kafka Service

Start Kafka service.

## Create the Topic

Create a Kafka topic. (better to create topic as test)

## Compile and Build the Fat Jar File

Open PowerShell as Administrator in the root project folder, compile the code using Maven and create an executable jar file. Generated artificacts can be found in the new 'target' folder.

```PowerShell
mvn clean compile assembly:single
```

## Start Consumer

Open PowerShell as Administrator in the root project folder, start the original consumer app using topic test and group1 with:

```PowerShell
java -cp target/kafka-mq-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar edu.northwestmissouri.bigdatabulls.simple.Consumer test group1
```

## Start Producer

Open a new PowerShell as Administrator in the root project folder, start the Producer app using topic test:

### To run ProducerTotalCount
```PowerShell
java -cp target/kafka-mq-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar edu.northwestmissouri.bigdatabulls.simple.ProducerTotalCount test
```

### To run ProducerMessages
```PowerShell
java -cp target/kafka-mq-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar edu.northwestmissouri.bigdatabulls.simple.ProducerMessages test
```
## Test Communications

1. Type some messages for the Producer.
1. Verify the messages are output by the Consumer.
