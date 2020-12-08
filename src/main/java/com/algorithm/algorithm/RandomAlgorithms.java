package com.algorithm.algorithm;

import java.math.BigDecimal;
import java.util.Random;

/**
 * 随机生成算法
 */
public class RandomAlgorithms {


    /**
     * 微信抢红包随机数算法
     */
    public double getRandomMoney(double remainMoney,int remainSize){
        //剩下最后一个人时，把钱发完
        if (remainSize==1){
            return remainMoney;
        }

        Random random = new Random();


        return 0.0;
    }
}
