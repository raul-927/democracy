package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.Address;
import com.democracy.hhrr.domain.ports.out.AddressOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.AddressMapper;
import liquibase.pro.packaged.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class AddressAdapter implements AddressOut {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Mono<Integer> createAddress(Address address) {
        return this.addressMapper.insert(address);
    }

    @Override
    public Mono<Integer> createMultipleAddress(List<Address> addressList) {
        return this.addressMapper.insertMultiple(addressList);
    }

    @Override
    public Mono<Integer> deleteAddress(String id) {
        return this.addressMapper.deleteAddress(id);
    }

    @Override
    public Flux<Address> selectAddress(Address address) {
        return this.addressMapper.selectAddress(address);
    }

    @Override
    public Mono<Long> selectCount() {
        return this.addressMapper.count();
    }

    @Override
    public Mono<Integer> updateAddress(Address address) {
        return this.addressMapper.updateSelectiveByPrimaryKey(address);
    }
}
