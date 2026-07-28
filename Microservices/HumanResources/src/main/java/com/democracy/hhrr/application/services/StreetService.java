package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.ports.reactive.in.street.CreateStreetIn;
import com.democracy.hhrr.domain.ports.reactive.in.street.DeleteStreetIn;
import com.democracy.hhrr.domain.ports.reactive.in.street.SelectStreetIn;
import com.democracy.hhrr.domain.ports.reactive.in.street.UpdateStreetIn;

public interface StreetService extends CreateStreetIn, UpdateStreetIn, DeleteStreetIn, SelectStreetIn {
}
