package com.example.algorithm.project.garbage_sorting;

import com.example.algorithm.entity.domain.GarbageSorting;
import com.example.algorithm.entity.vo.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: algorithm
 * @description: 垃圾分类
 * @author: pengpeng.wang.o
 * @create: 2019-06-15
 **/
@RestController
@RequestMapping("/garbage")
public class GarbageSortingController {

    private static final Logger logger = LoggerFactory.getLogger(GarbageSortingController.class);

    @Autowired
    private GarbageSortingService garbageSortingService;

    @GetMapping("/select/all")
    public BaseResult selectGarbage(){
        logger.info("/garbage/select/all,查询所有垃圾分类");
        List<GarbageSorting> result = garbageSortingService.selectGarbage();
        return new BaseResult(true,result);
    }

}
