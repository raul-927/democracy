package com.democracy.infrastructure.statemachine;

import org.apache.log4j.Logger;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@WithStateMachine
public class OnTransitionActions {

    static final Logger LOGGER2 = Logger.getLogger(OnTransitionActions.class);

    @OnTransition(source = "START", target = "WAITING_CUSTOMER_INPUT")
    public void method1(){
        LOGGER2.info("Transition: START -> WAITING_CUSTOMER_INPUT");
        LOGGER2.info("Current State: WAITING_CUSTOMER_INPUT");

        System.out.println("*********************Current State: WAITING_CUSTOMER_INPUT*********************");
    }

    @OnTransition(source = "WAITING_CUSTOMER_INPUT", target = "LOGIN_PAGE")
    public void method2(){
        LOGGER2.info("Transition: WAITING_CUSTOMER_INPUT -> LOGIN_PAGE");
        LOGGER2.info("Current State: LOGIN_PAGE");

        System.out.println("*********************Current State: LOGIN_PAGE*********************");
    }

    @OnTransition(source = "WAITING_CUSTOMER_INPUT", target = "SIGNUP_PAGE")
    public void method3(){
        LOGGER2.info("Transition: WAITING_CUSTOMER_INPUT -> SIGNUP_PAGE");
        LOGGER2.info("Current State: SIGNUP_PAGE");

        System.out.println("*********************Current State: SIGNUP_PAGE*********************");
    }

    @OnTransition(source = "LOGIN_PAGE", target = "LOGIN_PAGE")
    public void method4(){
        LOGGER2.info("Transition: LOGIN_PAGE -> LOGIN_PAGE");
        LOGGER2.info("Current State: LOGIN_PAGE");

        System.out.println("*********************Current State: LOGIN_PAGE*********************");
    }

    @OnTransition(source = "SIGNUP_PAGE", target = "SIGNUP_PAGE")
    public void method5(){
        LOGGER2.info("Transition: SIGNUP_PAGE -> SIGNUP_PAGE");
        LOGGER2.info("Current State: SIGNUP_PAGE");

        System.out.println("*********************Current State: SIGNUP_PAGE*********************");
    }

    @OnTransition(source = "LOGIN_PAGE", target = "CUSTOMER_AUTHENTICATED")
    public void method6(){
        LOGGER2.info("Transition: LOGIN_PAGE -> CUSTOMER_AUTHENTICATED");
        LOGGER2.info("Current State: CUSTOMER_AUTHENTICATED");

        System.out.println("*********************Current State: CUSTOMER_AUTHENTICATED*********************");
    }


    @OnTransition(source = "SIGNUP_PAGE", target = "CUSTOMER_SIGNEDUP")
    public void method7(){
        LOGGER2.info("Transition: SIGNUP_PAGE -> CUSTOMER_SIGNEDUP");
        LOGGER2.info("Current State: CUSTOMER_SIGNEDUP");

        System.out.println("*********************Current State: CUSTOMER_SIGNEDUP*********************");
    }


    @OnTransition(source = "CUSTOMER_AUTHENTICATED", target = "APPLICATION_UI_PAGE")
    public void method8(){
        LOGGER2.info("Transition: CUSTOMER_AUTHENTICATED -> APPLICATION_UI_PAGE");
        LOGGER2.info("Current State: APPLICATION_UI_PAGE");

        System.out.println("*********************Current State: APPLICATION_UI_PAGE*********************");
    }

    @OnTransition(source = "CUSTOMER_SIGNEDUP", target = "APPLICATION_UI_PAGE")
    public void method9(){
        LOGGER2.info("Transition: CUSTOMER_SIGNEDUP -> APPLICATION_UI_PAGE");
        LOGGER2.info("Current State: APPLICATION_UI_PAGE");

        System.out.println("*********************Current State: APPLICATION_UI_PAGE*********************");
    }

    @OnTransition(source = "APPLICATION_UI_PAGE", target = "END")
    public void method10(){
        LOGGER2.info("Transition: APPLICATION_UI_PAGE -> END");
        LOGGER2.info("Current State: END");

        System.out.println("*********************Current State: END*********************");
    }

    @OnTransition(source = "END", target = "WAITING_CUSTOMER_INPUT")
    public void method11(){
        LOGGER2.info("Transition: END -> WAITING_CUSTOMER_INPUT");
        LOGGER2.info("Current State: WAITING_CUSTOMER_INPUT");

        System.out.println("*********************Current State: WAITING_CUSTOMER_INPUT*********************");
    }

}
