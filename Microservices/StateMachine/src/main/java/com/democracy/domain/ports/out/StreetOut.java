package com.democracy.domain.ports.out;

import com.democracy.domain.models.Street;
import reactor.core.publisher.Mono;

public interface StreetOut {

    Mono<?> callStreet(Street street);
}
