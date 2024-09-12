package com.democracy.hhrr.application.usecases.city;

import com.democracy.hhrr.domain.ports.in.city.DeleteCityIn;
import com.democracy.hhrr.domain.ports.out.CityOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
public class DeleteCityUseCase implements DeleteCityIn {

    private final CityOut cityOut;

    public DeleteCityUseCase(CityOut cityOut) {
        this.cityOut = cityOut;
    }

    @Override
    public Mono<Integer> deleteCity(String id) {
        return this.cityOut.deleteCity(id);
    }
}
