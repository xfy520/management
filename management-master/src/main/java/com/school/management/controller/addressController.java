package com.school.management.controller;

import com.school.management.common.core.controller.BaseController;
import com.school.management.domain.Address;
import com.school.management.service.IAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("/address")
public class addressController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(addressController.class);

    @Resource
    private IAddressService addressService;

    @PostMapping("/selectProvince/{addressId}")
    @ResponseBody
    public List<Address> selectProvince(@PathVariable("addressId") Long addressId, ModelMap map){
        List<Address> list = addressService.selectProvince(addressId);
        return list;
    }
}
