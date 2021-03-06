package com.school.management.service.impl;

import com.school.management.domain.Address;
import com.school.management.mapper.AddressMapper;
import com.school.management.service.IAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    public List<Address> selectProvince(Long addressId) {
        return addressMapper.selectProvince(addressId);
    }
}
