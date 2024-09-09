package com.democracy.hhrr.application.usecases.neighborhood;

import com.democracy.hhrr.domain.models.Neighborhood;
import com.democracy.hhrr.domain.ports.in.neighborhood.UpdateNeighborhoodIn;
import com.democracy.hhrr.domain.ports.out.NeighborhoodOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UpdateNeighborhoodUseCase implements UpdateNeighborhoodIn {

    private final NeighborhoodOut neighborhoodOut;

    public UpdateNeighborhoodUseCase(NeighborhoodOut neighborhoodOut) {
        this.neighborhoodOut = neighborhoodOut;
    }

    @Override
    public Mono<Integer> updateNeighborhood(Neighborhood neighborhood) {
        return this.neighborhoodOut.updateNeighborhood(neighborhood);
    }
}
