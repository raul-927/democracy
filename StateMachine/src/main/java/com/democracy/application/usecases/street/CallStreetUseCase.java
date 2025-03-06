package com.democracy.application.usecases.street;

import com.democracy.domain.models.Street;
import com.democracy.domain.ports.in.CallStreetIn;
import com.democracy.infrastructure.events.EventEnum;
import com.democracy.infrastructure.satates.StateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.stereotype.Component;
import com.democracy.domain.ports.out.StreetOut;

@Component
public class CallStreetUseCase implements CallStreetIn {

    //private final StateMachine<StateEnum, EventEnum> stateMachine1;
    //private final StateMachineListener<StateEnum, EventEnum> listener;

    private final StreetOut streetOut;

    public CallStreetUseCase(StreetOut streetOut) {
        //this.stateMachine1 = stateMachine1;
        //this.listener = listener;
        this.streetOut = streetOut;
    }

    @Override
    public Street callStreet(Street street) {
        System.out.println("INICIA: ");
        //stateMachine1.start();
        //this.stateMachine1.sendEvent(EventEnum.RINSE);

		System.out.println("EVENT: "+EventEnum.RINSE);
		System.out.println("-----------END-------------------");

        //this.stateMachine1.sendEvent(EventEnum.DRY);
		System.out.println("EVENT: "+EventEnum.DRY);
		System.out.println("-----------END-------------------");

        //this.stateMachine1.sendEvent(EventEnum.CUT_POWER);
		System.out.println("EVENT: "+EventEnum.CUT_POWER);
		System.out.println("-----------END-------------------");

         return this.streetOut.callStreet(street);
    }
}
