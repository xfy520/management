package com.school.management.service.impl;

import com.school.management.mapper.IndexMapper;
import com.school.management.service.IIndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IndexServiceImpl implements IIndexService {

    @Resource
    private IndexMapper indexMapper;

}
