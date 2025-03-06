package com.democracy.infrastructure.statemachine;

import com.democracy.infrastructure.events.OrderEvents;
import com.democracy.infrastructure.satates.OrderStates;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;
import org.springframework.util.StringUtils;

@Log
//@Configuration
//@EnableStateMachineFactory
public class SimpleStateMachineConfiguration /*extends StateMachineConfigurerAdapter<OrderStates, OrderEvents> */{

    //@Override
    public void configure(StateMachineTransitionConfigurer<OrderStates,
            OrderEvents> transitions) throws Exception {
        System.out.println("ENTRO");
        transitions
                .withExternal()
                .source(OrderStates.SUBMITTED)
                .target(OrderStates.PAID)
                .event(OrderEvents.PAY)
                .guard(ctx -> {
                    System.out.println("true->statechanged. false->do not change ");
                    log.info("true->statechanged. false->do not change ");
                    var paymentType = String.class.cast(ctx.getExtendedState()
                            .getVariables().get("paymentType"));
                    if (!StringUtils.isEmpty(paymentType) && paymentType.equals("cod"))
                        return false;
                    else return true;
                })

                .and()
                .withExternal()
                .source(OrderStates.PAID)
                .target(OrderStates.FULFILLED)
                .event(OrderEvents.FULFILL)
                .action(ctx -> {
                    System.out.println("This PAID handler where we can perform some logging");
                    log.info("This PAID handler where we can perform some logging");
                })

                .and()
                .withExternal()
                .source(OrderStates.SUBMITTED)
                .target(OrderStates.CANCELLED)
                .event(OrderEvents.CANCEL)
                .action(ctx -> {
                    System.out.println("This SUBMITTED handler where we can perform some logging");
                    log.info("This SUBMITTED handler where we can perform some logging");
                })


                .and()
                .withExternal()
                .source(OrderStates.PAID)
                .target(OrderStates.CANCELLED)
                .event(OrderEvents.CANCEL)
                .action(ctx -> {
                    System.out.println("This PAID handler where we can perform some logging");
                    log.info("This PAID handler where we can perform some logging");
                });

    }

    //@Override
    public void configure(StateMachineStateConfigurer<OrderStates, OrderEvents> states) throws Exception {
        states
                .withStates()
                .initial(OrderStates.SUBMITTED)
                .state(OrderStates.PAID)
                .end(OrderStates.FULFILLED)
                .end(OrderStates.CANCELLED);
    }

    //@Override
    public void configure(StateMachineConfigurationConfigurer<OrderStates, OrderEvents> config) throws Exception {
        config.withConfiguration()
                .autoStartup(true);
    }

    //@Bean
    public Guard<OrderStates, OrderEvents> guard() {
        return ctx ->  true;
    }

    //@Bean
    public Action<OrderStates, OrderEvents> action() {
        return ctx -> System.out.println("ACTION");
    }
}
