package com.democracy.hhrr.application.services;


import com.democracy.hhrr.domain.models.City;
import com.democracy.hhrr.domain.ports.in.city.CreateCityIn;
import com.democracy.hhrr.domain.ports.in.city.DeleteCityIn;
import com.democracy.hhrr.domain.ports.in.city.SelectCityIn;
import com.democracy.hhrr.domain.ports.in.city.UpdateCityIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    private final CreateCityIn createCityIn;
    private final DeleteCityIn deleteCityIn;
    private final SelectCityIn selectCityIn;
    private final UpdateCityIn updateCityIn;

    public CityServiceImpl(CreateCityIn createCityIn,
                           DeleteCityIn deleteCityIn,
                           SelectCityIn selectCityIn,
                           UpdateCityIn updateCityIn) {
        this.createCityIn = createCityIn;
        this.deleteCityIn = deleteCityIn;
        this.selectCityIn = selectCityIn;
        this.updateCityIn = updateCityIn;
    }


    @Override
    public Mono<Integer> createCity(City city) {
        return this.createCityIn.createCity(city);
    }

    @Override
    public Mono<Integer> createMultipleCity(List<City> cityList) {
        return this.createCityIn.createMultipleCity(cityList);
    }

    @Override
    public Mono<Integer> deleteCity(String id) {
        return this.deleteCityIn.deleteCity(id);
    }

    @Override
    public Flux<City> selectCity(City city) {
        return this.selectCityIn.selectCity(city);
    }

    @Override
    public Mono<Long> selectCount() {
        return this.selectCityIn.selectCount();
    }

    @Override
    public Mono<Integer> updateCity(City city) {
        return this.updateCityIn.updateCity(city);
    }
}
