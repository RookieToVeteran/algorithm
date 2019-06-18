package com.example.algorithm.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GarbageSortingMapper {
    List<Map> selectGarbage();
}
