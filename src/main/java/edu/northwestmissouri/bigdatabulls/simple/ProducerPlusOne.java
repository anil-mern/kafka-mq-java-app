/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.northwestmissouri.bigdatabulls.simple;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author Sushmita Rudra
 */
public class ProducerPlusOne {
 private static Scanner in;
    private static int result = 0;

    public static void main(String[] argv)throws Exception {
        if (argv.length != 1) {
            System.err.println("Please specify 1 parameters ");
            System.exit(-1);
        }
        String topicName = argv[0];
        in = new Scanner(System.in);
        System.out.println("Enter message(type exit to quit)");

        //Configure the Producer
        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);
        String line = in.nextLine();
        
        while(!line.equals("exit")) {
            
            
            //TODO: Make sure to use the ProducerRecord constructor that does not take parition Id
            result = plusOne(line, 1);
            ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName,result+"");
            producer.send(rec);
            line = in.nextLine();
        }
        in.close();
        
        producer.close();
    }
   
    private static int plusOne(String numberEntered, int addOne) {
         int numEntered = Integer.parseInt(numberEntered);
        return numEntered + addOne;
    }
}


