package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.models.Neighborhood;
import com.democracy.hhrr.domain.ports.in.neighborhood.CreateNeighborhoodIn;
import com.democracy.hhrr.domain.ports.in.neighborhood.DeleteNeighborhoodIn;
import com.democracy.hhrr.domain.ports.in.neighborhood.SelectNeighborhoodIn;
import com.democracy.hhrr.domain.ports.in.neighborhood.UpdateNeighborhoodIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class NeighborhoodServiceImpl implements NeighborhoodService{

    private final CreateNeighborhoodIn createNeighborhoodIn;
    private final DeleteNeighborhoodIn deleteNeighborhoodIn;
    private final SelectNeighborhoodIn selectNeighborhoodIn;
    private final UpdateNeighborhoodIn updateNeighborhoodIn;

    public NeighborhoodServiceImpl(CreateNeighborhoodIn createNeighborhoodIn,
                                   DeleteNeighborhoodIn deleteNeighborhoodIn,
                                   SelectNeighborhoodIn selectNeighborhoodIn,
                                   UpdateNeighborhoodIn updateNeighborhoodIn) {
        this.createNeighborhoodIn = createNeighborhoodIn;
        this.deleteNeighborhoodIn = deleteNeighborhoodIn;
        this.selectNeighborhoodIn = selectNeighborhoodIn;
        this.updateNeighborhoodIn = updateNeighborhoodIn;
    }


    @Override
    public Mono<Integer> createNeighborhood(Neighborhood neighborhood) {
        return this.createNeighborhoodIn.createNeighborhood(neighborhood);
    }

    @Override
    public Mono<Integer> createMultipleNeighborhood(List<Neighborhood> neighborhoodList) {
        return this.createNeighborhoodIn.createMultipleNeighborhood(neighborhoodList);
    }

    @Override
    public Mono<Integer> deleteNeighborhood(String neighborhoodId) {
        return this.deleteNeighborhoodIn.deleteNeighborhood(neighborhoodId);
    }

    @Override
    public Flux<Neighborhood> selectNeighborhood(Neighborhood neighborhood) {
        return this.selectNeighborhoodIn.selectNeighborhood(neighborhood);
    }

    @Override
    public Mono<Long> selectCount() {
        return this.selectNeighborhoodIn.selectCount();
    }

    @Override
    public Mono<Integer> updateNeighborhood(Neighborhood neighborhood) {
        return this.updateNeighborhoodIn.updateNeighborhood(neighborhood);
    }
}
