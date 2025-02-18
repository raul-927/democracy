package com.democracy.infrastructure.statemachine;


import com.democracy.infrastructure.events.EventEnum;
import com.democracy.infrastructure.satates.StateEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class CalculateInvoices extends EnumStateMachineConfigurerAdapter<StateEnum, EventEnum> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<StateEnum, EventEnum> config)
            throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<StateEnum, EventEnum> states)
            throws Exception {
        states
                .withStates()
                .initial(StateEnum.INDEX)
                .states(EnumSet.allOf(StateEnum.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<StateEnum, EventEnum> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(StateEnum.INDEX)
                    .target(StateEnum.CALCULATE_INVOICES)
                        .event(EventEnum.CALL_INVOICES)
                .and()
                .withExternal()
                .source(StateEnum.CALCULATE_INVOICES)
                    .target(StateEnum.END)
                        .event(EventEnum.CALL_END);
    }

    @Bean
    public StateMachineListener<StateEnum, EventEnum> listener() {
        return new StateMachineListenerAdapter<StateEnum, EventEnum>() {
            @Override
            public void stateChanged(State<StateEnum, EventEnum> from, State<StateEnum, EventEnum> to) {
                System.out.println("State change to " + to.getId());
            }
        };
    }
}
