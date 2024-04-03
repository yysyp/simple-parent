package com.example.news.util;

import org.apache.commons.lang3.RandomUtils;
import org.bson.internal.Base64;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    @Test
    void randomTest() {
        int length = 1024;
        byte[] bytes = RandomUtils.nextBytes(length);
        String base64 = Base64.encode(bytes);
        System.out.println(base64);
    }
}
