package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.ports.in.street.CreateStreetIn;
import com.democracy.hhrr.domain.ports.in.street.DeleteStreetIn;
import com.democracy.hhrr.domain.ports.in.street.SelectStreetIn;
import com.democracy.hhrr.domain.ports.in.street.UpdateStreetIn;

public interface StreetService extends CreateStreetIn, UpdateStreetIn, DeleteStreetIn, SelectStreetIn {
}
