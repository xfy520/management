package com.school.management.mapper;

import com.school.management.domain.Address;

import java.util.List;

public interface AddressMapper {

    List<Address> selectProvince(Long addressId);
}
