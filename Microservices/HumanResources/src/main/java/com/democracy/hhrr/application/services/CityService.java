package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.ports.in.city.CreateCityIn;
import com.democracy.hhrr.domain.ports.in.city.DeleteCityIn;
import com.democracy.hhrr.domain.ports.in.city.SelectCityIn;
import com.democracy.hhrr.domain.ports.in.city.UpdateCityIn;

public interface CityService extends CreateCityIn, DeleteCityIn, SelectCityIn, UpdateCityIn {
}
