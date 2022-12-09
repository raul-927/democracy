package com.democracy.person.messages;

import com.democracy.person.domain.User;
import com.democracy.person.messages.produces.PersonProduce;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final PersonProduce jsonProducer;

    public CommandLineAppStartupRunner(PersonProduce jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @Override
    public void run(String... args) throws Exception {
        jsonProducer.sendMessage(new User("Larry"));
        jsonProducer.sendMessage(new User("The Edge"));
        jsonProducer.sendMessage(new User("Charly"));
    }
}
