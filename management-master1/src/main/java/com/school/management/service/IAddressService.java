package com.school.management.service;

import com.school.management.domain.Address;

import java.util.List;

public interface IAddressService {

    List<Address> selectProvince(Long addressId);
}
