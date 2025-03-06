package com.democracy.domain.ports.out;

import com.democracy.domain.models.Street;
import reactor.core.publisher.Mono;

public interface StreetOut {

    Street callStreet(Street street);
}
