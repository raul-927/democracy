package com.democracy.infrastructure.statemachine;


import com.democracy.infrastructure.events.EventEnum;
import com.democracy.infrastructure.satates.StateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.config.configurers.StateConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

//@Configuration
//@EnableStateMachine(name = "stateMachine1")
public class CalculateInvoices extends EnumStateMachineConfigurerAdapter<StateEnum, EventEnum> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<StateEnum, EventEnum> config)
            throws Exception {
        config
                .withConfiguration()
                //.autoStartup(true)
                .listener(listener());
    }



    @Override
    public void configure(StateMachineStateConfigurer<StateEnum, EventEnum> states)
            throws Exception {
        states
                .withStates()
                .initial(StateEnum.RUNNING)
                .state(StateEnum.POWEROFF)
                .end(StateEnum.END)
                .and()
                .withStates()
                .parent(StateEnum.RUNNING)
                .initial(StateEnum.WASHING)
                .state(StateEnum.RINSING)
                .state(StateEnum.DRYING)
                .history(StateEnum.HISTORY, StateConfigurer.History.SHALLOW);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<StateEnum, EventEnum> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(StateEnum.WASHING)
                    .target(StateEnum.RINSING)
                    .event(EventEnum.RINSE)
                .and()
                .withExternal()
                .source(StateEnum.RINSING)
                    .target(StateEnum.DRYING)
                    .event(EventEnum.DRY)
                .and()
                .withExternal()
                .source(StateEnum.RUNNING)
                    .target(StateEnum.POWEROFF)
                    .event(EventEnum.CUT_POWER)
                .and()
                .withExternal()
                .source(StateEnum.POWEROFF)
                    .target(StateEnum.HISTORY)
                    .event(EventEnum.RESTORE_POWER)
                .and()
                .withExternal()
                .source(StateEnum.RUNNING)
                    .target(StateEnum.END)
                    .event(EventEnum.STOP);
    }

    @Bean
    public StateMachineListener<StateEnum, EventEnum> listener() {
        return new StateMachineListenerAdapter<StateEnum, EventEnum>() {
            @Override
            public void stateChanged(State<StateEnum, EventEnum> from, State<StateEnum, EventEnum> to) {
                System.out.println("-----------INIT-------------------");
                if(from!=null && from.getId()!=null){
                    System.out.println("State from: " + from.getId());
                    System.out.println("State change to: " + to.getId());
                }

            }
        };
    }
}
