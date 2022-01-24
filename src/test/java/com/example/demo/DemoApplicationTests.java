package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() throws Exception{
        AES256Cipher a256 = AES256Cipher.getInstance();
        System.out.println(a256.AES_Encode("82047550"));
    }

}
