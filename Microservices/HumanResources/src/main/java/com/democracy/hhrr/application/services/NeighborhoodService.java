package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.ports.in.neighborhood.CreateNeighborhoodIn;
import com.democracy.hhrr.domain.ports.in.neighborhood.DeleteNeighborhoodIn;
import com.democracy.hhrr.domain.ports.in.neighborhood.SelectNeighborhoodIn;
import com.democracy.hhrr.domain.ports.in.neighborhood.UpdateNeighborhoodIn;

public interface NeighborhoodService extends CreateNeighborhoodIn, DeleteNeighborhoodIn, SelectNeighborhoodIn, UpdateNeighborhoodIn {
}
