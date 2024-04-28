package kafak.test.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author stopping
 * @Description: TODO
 * @date 2024/4/28 4:40 PM
 */
public class KafkaConsumerTest {

    public static final String SERVER = "127.0.0.1:9092";
    public static void main(String[] args) throws InterruptedException {
        Map<String,Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,SERVER);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"test");

        KafkaConsumer<String,String> consumer = new KafkaConsumer<String,String>(config);

        consumer.subscribe(Collections.singleton("stopping-topic"));

        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
        while (true){
            System.out.println("拉去数据数量 = " + records.count());
            Thread.sleep(1000);

            for (ConsumerRecord<String, String> record : records) {
                System.out.println("拉取数据: key = " + record.key() + ",val =" + record.value());
            }
        }


    }
}
