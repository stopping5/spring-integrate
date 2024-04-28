package kafak.test.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author stopping
 * @date 2024/4/28 4:27 PM
 */
public class KafkaProducerTest {

    public static final String SERVER = "127.0.0.1:9092";

    public static void main(String[] args) {
        Map<String,Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,SERVER);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        KafkaProducer<String,String> producer = new KafkaProducer<String,String>(config);
        ProducerRecord<String,String> record = new ProducerRecord<>("stopping-topic","key","value");
        producer.send(record);
        producer.close();

    }
}
