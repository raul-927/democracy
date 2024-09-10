package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.ports.in.address.CreateAddressIn;
import com.democracy.hhrr.domain.ports.in.address.DeleteAddressIn;
import com.democracy.hhrr.domain.ports.in.address.SelectAddressIn;
import com.democracy.hhrr.domain.ports.in.address.UpdateAddressIn;

public interface AddressService extends CreateAddressIn, DeleteAddressIn, SelectAddressIn, UpdateAddressIn {
}
