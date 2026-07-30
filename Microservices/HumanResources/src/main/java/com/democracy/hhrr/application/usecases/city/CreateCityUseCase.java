package com.democracy.hhrr.application.usecases.city;

import com.democracy.hhrr.domain.models.City;
import com.democracy.hhrr.domain.ports.in.city.CreateCityIn;
import com.democracy.hhrr.domain.ports.out.CityOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Component
public class CreateCityUseCase implements CreateCityIn {

    private final CityOut cityOut;

    public CreateCityUseCase(CityOut cityOut) {
        this.cityOut = cityOut;
    }

    @Override
    public Mono<Integer> createCity(City city) {
        city.setCityId(UUID.randomUUID().toString());
        return this.cityOut.createCity(city);
    }

    @Override
    public Mono<Integer> createMultipleCity(List<City> cityList) {
        cityList.forEach(city->{
            city.setCityId(UUID.randomUUID().toString());
        });
        return this.cityOut.createMultipleCity(cityList);
    }
}
