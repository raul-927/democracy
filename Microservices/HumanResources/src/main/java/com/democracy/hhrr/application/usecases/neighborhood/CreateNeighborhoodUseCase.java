package com.democracy.hhrr.application.usecases.neighborhood;

import com.democracy.hhrr.domain.aux.NeighborhoodStreet;
import com.democracy.hhrr.domain.models.Neighborhood;
import com.democracy.hhrr.domain.ports.in.neighborhood.CreateNeighborhoodIn;
import com.democracy.hhrr.domain.ports.out.NeighborhoodOut;
import com.democracy.hhrr.domain.ports.out.aux.neighborhoodstreet.NeighborhoodStreetOut;
import org.springframework.boot.web.embedded.netty.NettyWebServer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@Component
public class CreateNeighborhoodUseCase implements CreateNeighborhoodIn {

    private final NeighborhoodOut neighborhoodOut;
    private final NeighborhoodStreetOut neighborhoodStreetOut;

    public CreateNeighborhoodUseCase(NeighborhoodOut neighborhoodOut, NeighborhoodStreetOut neighborhoodStreetOut) {
        this.neighborhoodOut = neighborhoodOut;
        this.neighborhoodStreetOut = neighborhoodStreetOut;
    }

    @Override
    public Mono<Integer> createNeighborhood(Neighborhood neighborhood) {
        Mono<Integer> results = this.neighborhoodOut.createNeighborhood(neighborhood);
        neighborhood.getStreets().forEach( rr->{
            NeighborhoodStreet neighborhoodStreet = new NeighborhoodStreet();
            neighborhoodStreet.setNeighborhoodId(neighborhood.getNeighborhoodId());
            neighborhoodStreet.setStreetId(rr.getStreetId());
            List<NeighborhoodStreet> neighborhoodStreetList = new ArrayList<>();
            neighborhoodStreetList.add(neighborhoodStreet);
            this.neighborhoodStreetOut.createMultipleNeighStreet(neighborhoodStreetList);
        });


        return results;
    }

    @Override
    public Mono<Integer> createMultipleNeighborhood(List<Neighborhood> neighborhoodList) {
        return null;
    }
}
