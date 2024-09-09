package com.democracy.hhrr.application.usecases.neighborhood;


import com.democracy.hhrr.domain.ports.in.neighborhood.DeleteNeighborhoodIn;
import com.democracy.hhrr.domain.ports.out.NeighborhoodOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DeleteNeighborhoodUseCase implements DeleteNeighborhoodIn {

    private final NeighborhoodOut neighborhoodOut;

    public DeleteNeighborhoodUseCase(NeighborhoodOut neighborhoodOut) {
        this.neighborhoodOut = neighborhoodOut;
    }

    @Override
    public Mono<Integer> deleteNeighborhood(String neighborhoodId) {
        return this.neighborhoodOut.deleteNeighborhood(neighborhoodId);
    }
}
