package com.democracy.infrastructure.statemachine;

import com.democracy.infrastructure.events.EventEnum;
import com.democracy.infrastructure.satates.StateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.statemachine.StateMachine;

public class RunStateMachine {
    //@Autowired
    StateMachine<StateEnum, EventEnum> stateMachine;

    public void fireEvent(EventEnum event){
        stateMachine.start();
        stateMachine.sendEvent(event);

        /*
         * stateMachine.stop();
        if(event == Events.LOG_OUT)
            stateMachine.stop();*/
    }
}
