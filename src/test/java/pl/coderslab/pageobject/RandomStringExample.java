package pl.coderslab.pageobject;

import java.util.UUID;

public class RandomStringExample {
    public static void main(String[] args) {
        for(int i = 0; i<10;i++) {
            String uuid = UUID.randomUUID().toString();
            String randomStr = uuid.replaceAll("[-0-9]", "");
            System.out.println(randomStr);
        }
    }
}
