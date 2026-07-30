package com.democracy.hhrr.application.usecases.city;

import com.democracy.hhrr.domain.models.City;
import com.democracy.hhrr.domain.ports.in.city.UpdateCityIn;
import com.democracy.hhrr.domain.ports.out.CityOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
public class UpdateCityUseCase implements UpdateCityIn {

    private final CityOut cityOut;

    public UpdateCityUseCase(CityOut cityOut) {
        this.cityOut = cityOut;
    }

    @Override
    public Mono<Integer> updateCity(City city) {
        return this.cityOut.updateCity(city);
    }
}
