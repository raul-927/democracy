package com.democracy.electoral_court.infrastructure.publisher;


import com.democracy.electoral_court.domain.models.InvestigationResult;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import com.google.gson.Gson;

@Component
public class EventPublisher {

    private final Sinks.Many<String> eventSink;
    private Disposable intervalSubscription;

    public EventPublisher() {
        this.eventSink = Sinks.many().multicast().onBackpressureBuffer();
    }

    //@PostConstruct
    public void init(InvestigationResult investigationResult) {
        Gson gson = new Gson();
        String json = gson.toJson(investigationResult);
        intervalSubscription = Flux.just(json)
                .doOnNext(event -> {
                    Sinks.EmitResult result = eventSink.tryEmitNext(event);
                    System.out.println("Result: "+result);
                    if (result.isFailure()) {
                        // Log the failure or take appropriate action
                        System.err.println("Emission failed: " + result);
                    }
                })
                .subscribe();
    }

   public Flux<String> getEventStream() {
        return eventSink.asFlux();
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Finaliza");
        if (intervalSubscription != null && !intervalSubscription.isDisposed()) {
            intervalSubscription.dispose();
        }
    }
}