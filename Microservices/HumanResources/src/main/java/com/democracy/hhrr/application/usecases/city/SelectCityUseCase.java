package com.democracy.hhrr.application.usecases.city;

import com.democracy.hhrr.domain.models.City;
import com.democracy.hhrr.domain.ports.in.city.SelectCityIn;
import com.democracy.hhrr.domain.ports.out.CityOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SelectCityUseCase implements SelectCityIn {

    private final CityOut cityOut;

    public SelectCityUseCase(CityOut cityOut) {
        this.cityOut = cityOut;
    }

    @Override
    public Flux<City> selectCity(City city) {
        return this.cityOut.selectCity(city);
    }

    @Override
    public Mono<Long> selectCount() {
        return this.cityOut.selectCount();
    }

    @Override
    public Flux<City> selectAllCity() {
        return this.cityOut.selectAllCity();
    }
}
