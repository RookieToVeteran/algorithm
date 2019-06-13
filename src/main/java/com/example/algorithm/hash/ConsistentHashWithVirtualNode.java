package com.example.algorithm.hash;

import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

/**
 * @program: algorithm
 * @description: 带有虚拟节点的一致性hash
 * @author: pengpeng.wang.o
 * @create: 2019-06-13
 **/
public class ConsistentHashWithVirtualNode {

    /**
     * 服务器节点信息
     */
    private static SortedMap<Integer,String> nodeMap = new TreeMap<>();

    private static final int VIRTUAL_NODE_COUNT = 5;

    private static String [] servers = {
            "192.168.56.120:13009",
            "192.168.56.121:13009",
            "192.168.56.122:13009",
            "192.168.56.123:13009",
            "192.168.56.124:13009"
    };

    static{
        for (int i = 0; i < servers.length; i++) {
            for (int j = 0; j < VIRTUAL_NODE_COUNT; j++) {
                String server = servers[i];
                String serverKey = server +"&"+j;
                nodeMap.put(hash(serverKey),server);
                System.out.println("hash:"+hash(serverKey));
            }
        }
        System.out.println("============");
    }

    public static int hash(String key){
        if (StringUtils.isEmpty(key)){
            return 0;
        }else {
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                key = new String(md5.digest(key.getBytes()));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            int hash = 6271;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                hash+=(hash<<5)+c;
            }
            return hash>0?hash:-hash;
        }
    }


    public static String getServer(String key){
        int hash = hash(key);
        SortedMap<Integer, String> sortedMap = nodeMap.tailMap(hash);
        if (sortedMap.isEmpty()){
            Integer integer = nodeMap.firstKey();
            System.out.println(key+":被路由到节点： \n"+nodeMap.get(integer));
            return nodeMap.get(integer);
        }else{
            Integer integer = sortedMap.firstKey();
            System.out.println(key+":被路由到节点： \n"+sortedMap.get(integer));
            return sortedMap.get(integer );
        }
    }

    public static void main(String[] args) {
        for (int i = 1;i<10;i++){
            String s = UUID.randomUUID().toString();
            getServer(s);
        }
    }
}
