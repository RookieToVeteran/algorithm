package com.algorithm.test;

import com.algorithm.dto.User;
import com.algorithm.test.single.SingleObject3;
import com.algorithm.test.single.SingleObjectEnum;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SimpleTest {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializebleUser();
        deSerializebelUser();
        SingleObject3 value =  SingleObjectEnum.INSTANCE.getValue();
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
