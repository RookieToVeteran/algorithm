package com.algorithm.project.controller.garbagehandle;

import com.algorithm.entity.domain.GarbageSorting;
import com.algorithm.entity.vo.BaseResult;
import com.algorithm.project.service.garbagehandle.GarbageSortingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        for (GarbageSorting garbageSorting : result) {
            System.out.println(garbageSorting);
        }
        return new BaseResult(true,result);
    }

}
