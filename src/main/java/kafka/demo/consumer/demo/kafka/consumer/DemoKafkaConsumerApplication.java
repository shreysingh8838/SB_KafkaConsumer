package kafka.demo.consumer.demo.kafka.consumer;

import kafka.demo.consumer.demo.kafka.consumer.config.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication

@RestController
public class DemoKafkaConsumerApplication {

	List<String> messages = new ArrayList<>();

	User userFromTopic = null;

	@GetMapping("/consumeStringMessage")
	public List<String> consumeMessage(){
		return messages;
	}

	@KafkaListener(groupId = "test-group", topics = "test-topic", containerFactory = "kafkaListenerContainerFactory")
	public List<String> getMsgFromTopics(String data){
		messages.add(data);
		return messages;
	}

	@GetMapping("/consumeJsonMessage")
	public User consumeJsonMessage(){
		return userFromTopic;
	}

	@KafkaListener(groupId = "test-group", topics = "test-topic", containerFactory = "userKafkaListenerContainerFactory")
	public User getJsonMsgFromTopic(User user) {
		userFromTopic = user;
		return userFromTopic;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoKafkaConsumerApplication.class, args);
	}
}
