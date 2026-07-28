package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.ports.reactive.in.address.CreateAddressIn;
import com.democracy.hhrr.domain.ports.reactive.in.address.DeleteAddressIn;
import com.democracy.hhrr.domain.ports.reactive.in.address.SelectAddressIn;
import com.democracy.hhrr.domain.ports.reactive.in.address.UpdateAddressIn;

public interface AddressService extends CreateAddressIn, DeleteAddressIn, SelectAddressIn, UpdateAddressIn {
}
