package com.democracy.hhrr.application.usecases.neighborhood;

import com.democracy.hhrr.domain.models.Neighborhood;
import com.democracy.hhrr.domain.ports.in.neighborhood.CreateNeighborhoodIn;
import com.democracy.hhrr.domain.ports.out.NeighborhoodOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
public class CreateNeighborhoodUseCase implements CreateNeighborhoodIn {

    private final NeighborhoodOut neighborhoodOut;

    public CreateNeighborhoodUseCase(NeighborhoodOut neighborhoodOut) {
        this.neighborhoodOut = neighborhoodOut;
    }

    @Override
    public Mono<Integer> createNeighborhood(Neighborhood neighborhood) {
        return this.neighborhoodOut.createNeighborhood(neighborhood);
    }

    @Override
    public Mono<Integer> createMultipleNeighborhood(List<Neighborhood> neighborhoodList) {
        return null;
    }
}
