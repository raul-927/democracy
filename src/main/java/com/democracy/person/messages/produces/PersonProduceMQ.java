package com.democracy.person.messages.produces;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PersonProduceMQ {
    String CHANNELNAME = "prueba-produce";

    @Output(CHANNELNAME)
    MessageChannel output();
}
