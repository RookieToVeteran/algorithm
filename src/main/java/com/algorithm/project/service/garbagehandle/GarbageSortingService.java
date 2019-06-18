package com.algorithm.project.service.garbagehandle;

import com.algorithm.entity.domain.GarbageSorting;

import java.util.List;

public interface GarbageSortingService {
    List<GarbageSorting> selectGarbage();
}
