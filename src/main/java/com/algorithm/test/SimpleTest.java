package com.algorithm.test;

import com.algorithm.dto.User;

import java.io.*;

public class SimpleTest {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        serializebleUser();
        deSerializebelUser();
    }

    private static void deSerializebelUser() throws IOException, ClassNotFoundException {
        ObjectInputStream ins = new ObjectInputStream(new FileInputStream("d://user.txt"));
        Object o = ins.readObject();
        System.out.println(o.toString());
    }

    private static void serializebleUser() throws IOException {
        User user = new User();
        user.setPhone("112345678");
        user.setName("测试");
        user.setTestId("12378");

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("d://user.txt"));
        outputStream.writeObject(user);
        outputStream.close();
        System.out.println(user.toString());
    }
}
