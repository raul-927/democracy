package com.democracy.person.messages.produces;

import com.democracy.person.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PersonProduce {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonProduce.class);
    private static final String CHANNELNAME = "prueba-produce";

    @Autowired
    @Qualifier("kafkaJsonTemplate")
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {
        LOGGER.info("Producing message {}", user);
        this.kafkaTemplate.send(PersonProduceMQ.CHANNELNAME, user);
    }
}
