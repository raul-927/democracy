package com.democracy.person.messages.consumes;

import com.democracy.person.domain.Person;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface PersonConsumeMQ {
    String CHANNELNAME = "prueba-consume";

    @Input(CHANNELNAME)
    MessageChannel input(Person person);
}
