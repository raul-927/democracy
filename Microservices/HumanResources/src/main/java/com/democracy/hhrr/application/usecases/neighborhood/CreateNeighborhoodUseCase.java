package com.democracy.hhrr.application.usecases.neighborhood;

import com.democracy.hhrr.application.services.aux.NeighborhoodStreetService;
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
import java.util.UUID;


@Component
public class CreateNeighborhoodUseCase implements CreateNeighborhoodIn {

    private final NeighborhoodOut neighborhoodOut;
    private final NeighborhoodStreetService neighborhoodStreetService;

    public CreateNeighborhoodUseCase(NeighborhoodOut neighborhoodOut, NeighborhoodStreetService neighborhoodStreetService) {
        this.neighborhoodOut = neighborhoodOut;
        this.neighborhoodStreetService = neighborhoodStreetService;
    }

    @Override
    public Mono<?> createNeighborhood(Neighborhood neighborhood) {
        neighborhood.setNeighborhoodId(UUID.randomUUID().toString());
        return this.neighborhoodOut.createNeighborhood(neighborhood);
    }

    @Override
    public Mono<Integer> createMultipleNeighborhood(List<Neighborhood> neighborhoodList) {
        return null;
    }
}
