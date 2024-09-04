package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.models.Street;
import com.democracy.hhrr.domain.ports.in.street.CreateStreetIn;
import com.democracy.hhrr.domain.ports.in.street.DeleteStreetIn;
import com.democracy.hhrr.domain.ports.in.street.SelectStreetIn;
import com.democracy.hhrr.domain.ports.in.street.UpdateStreetIn;
import com.rabbitmq.client.AMQP;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService{

    private final CreateStreetIn  createStreetIn;
    private final UpdateStreetIn updateStreetIn;
    private final SelectStreetIn selectStreetIn;
    private final DeleteStreetIn deleteStreetIn;

    public StreetServiceImpl(CreateStreetIn createStreetIn,
                             UpdateStreetIn updateStreetIn,
                             SelectStreetIn selectStreetIn,
                             DeleteStreetIn deleteStreetIn) {
        this.createStreetIn = createStreetIn;
        this.updateStreetIn = updateStreetIn;
        this.selectStreetIn = selectStreetIn;
        this.deleteStreetIn = deleteStreetIn;
    }


    @Override
    public Mono<Integer> createStreet(Street street) {
        return this.createStreetIn.createStreet(street);
    }

    @Override
    public Mono<Integer> createMultipleStreet(List<Street> streetList) {
        return this.createStreetIn.createMultipleStreet(streetList);
    }

    @Override
    public Mono<Integer> deleteStreet(String streetId) {
        return this.deleteStreetIn.deleteStreet(streetId);
    }

    @Override
    public Flux<Street> selectStreet(Street street) {
        return this.selectStreetIn.selectStreet(street);
    }

    @Override
    public Mono<Long> selectCount() {
        return this.selectStreetIn.selectCount();
    }

    @Override
    public Mono<Integer> updateStreet(Street street) {
        return this.updateStreetIn.updateStreet(street);
    }
}