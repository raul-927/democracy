package com.democracy.electoral_court.infrastructure.web.rest;



import com.democracy.electoral_court.infrastructure.publisher.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/electoralcourt")
public class EventDrivenController {
    @Autowired
    private EventPublisher eventPublisher;

    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getEventStream() {
        return eventPublisher.getEventStream();
    }

    @GetMapping(value = "/clean", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public String getClean() {
        eventPublisher.cleanup();
        return "Limpio";
    }
}
