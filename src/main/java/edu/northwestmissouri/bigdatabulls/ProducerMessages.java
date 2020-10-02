package edu.northwestmissouri.bigdatabulls.simple;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class ProducerMessages {
    private static Scanner in;

    public static void main(String[] argv) throws Exception {
      if (argv.length != 1) {
        System.err.println("Please specify 1 parameter (the name of the topic)");
        System.exit(-1);
      }
      String topicName = argv[0];
      in = new Scanner(System.in);
      System.out.println("Thank you for providing the topic " + topicName + "\n");
      System.out.println("Enter message (type exit to quit).\n");
  
      // Configure the Producer
      Properties configProperties = new Properties();
      configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
      configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
          "org.apache.kafka.common.serialization.ByteArraySerializer");
      configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
          "org.apache.kafka.common.serialization.StringSerializer");
      System.out.println("The configuration properties are: " + configProperties.toString());
      System.out.println("\nWill use this configuration to create a producer.\n");
  
      org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);
  
      // Make our own messages - create your custom logic
        for (int i=0; i<5; i++) {
          String message = "quotes "+i+" -- "+createMessages(i);
          ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, message);
          producer.send(rec);
        }
    
  
      // still allow input from keyboard
  
      String line = in.nextLine();
      while (!line.equals("exit")) {
        ProducerRecord<String, String> rec1 = new ProducerRecord<String, String>(topicName, line);
        producer.send(rec1);
        line = in.nextLine();
      }
  
      in.close();
      producer.close();
  
    }
  
    private static String createMessages(int index) {
      String[] messagesArray = {
       "Velocity: the speed at which the data is been generated",
       "Volume: the amount of the data that is been generated",
       "Variety: the diversity or different types of the data",
       "Value: the worth of the data or the value it has",
       "Veracity: the quality, accuracy, or trustworthiness of the data"
    };
      return messagesArray[index];
       
    }
}