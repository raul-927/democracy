package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.models.Address;
import com.democracy.hhrr.domain.ports.in.address.CreateAddressIn;
import com.democracy.hhrr.domain.ports.in.address.DeleteAddressIn;
import com.democracy.hhrr.domain.ports.in.address.SelectAddressIn;
import com.democracy.hhrr.domain.ports.in.address.UpdateAddressIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    private final CreateAddressIn createAddressIn;
    private final DeleteAddressIn deleteAddressIn;
    private final SelectAddressIn selectAddressIn;
    private final UpdateAddressIn updateAddressIn;

    public AddressServiceImpl(CreateAddressIn createAddressIn,
                              DeleteAddressIn deleteAddressIn,
                              SelectAddressIn selectAddressIn,
                              UpdateAddressIn updateAddressIn) {
        this.createAddressIn = createAddressIn;
        this.deleteAddressIn = deleteAddressIn;
        this.selectAddressIn = selectAddressIn;
        this.updateAddressIn = updateAddressIn;
    }


    @Override
    public Mono<Integer> createAddress(Address address) {
        return this.createAddressIn.createAddress(address);
    }

    @Override
    public Mono<Integer> createMultipleAddress(List<Address> addressList) {
        return this.createAddressIn.createMultipleAddress(addressList);
    }

    @Override
    public Mono<Integer> deleteAddress(String id) {
        return this.deleteAddressIn.deleteAddress(id);
    }

    @Override
    public Flux<Address> selectAddress(Address address) {
        return this.selectAddressIn.selectAddress(address);
    }

    @Override
    public Mono<Long> selectCount() {
        return this.selectAddressIn.selectCount();
    }

    @Override
    public Mono<Integer> updateAddress(Address address) {
        return this.updateAddressIn.updateAddress(address);
    }
}
