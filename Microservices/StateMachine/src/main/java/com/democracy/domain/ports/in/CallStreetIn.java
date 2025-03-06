package com.democracy.domain.ports.in;

import com.democracy.domain.models.Street;
import reactor.core.publisher.Mono;

public interface CallStreetIn {

    Mono<?> callStreet(Street street);
}
