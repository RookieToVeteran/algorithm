package com.algorithm.project.service.garbagehandle;

import com.algorithm.entity.domain.GarbageSorting;
import com.algorithm.project.mapper.GarbageSortingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: algorithm
 * @description: 实现类
 * @author: pengpeng.wang.o
 * @create: 2019-06-15
 **/
@Service
public class GarbageSortingServiceImpl implements GarbageSortingService{

    private static final Logger logger = LoggerFactory.getLogger(GarbageSortingServiceImpl.class);

    @Autowired
    private GarbageSortingMapper mapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<GarbageSorting> selectGarbage() {
        List<GarbageSorting> result = mapper.selectAll();
        return result;
    }
}
