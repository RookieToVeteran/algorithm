package com.example.algorithm.project.garbage_sorting;

import com.example.algorithm.project.mapper.GarbageSortingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<Map> selectGarbage() {
        List<Map> result = mapper.selectGarbage();
        return result;
    }
}
