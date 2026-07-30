package com.democracy.hhrr.application.usecases.neighborhood;

import com.democracy.hhrr.domain.models.Neighborhood;
import com.democracy.hhrr.domain.ports.in.neighborhood.SelectNeighborhoodIn;
import com.democracy.hhrr.domain.ports.out.NeighborhoodOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class SelectNeighborhoodUseCase implements SelectNeighborhoodIn {

    private final NeighborhoodOut neighborhoodOut;

    public SelectNeighborhoodUseCase(NeighborhoodOut neighborhoodOut) {
        this.neighborhoodOut = neighborhoodOut;
    }

    @Override
    public Flux<Neighborhood> selectNeighborhood(Neighborhood neighborhood) {
        return this.neighborhoodOut.selectNeighborhood(neighborhood);
    }

    @Override
    public Mono<Long> selectCount() {
        return this.neighborhoodOut.selectCount();
    }

    @Override
    public Flux<Neighborhood> selectAllNeighborhood() {
        return neighborhoodOut.selectAllNeighborhood();
    }
}
