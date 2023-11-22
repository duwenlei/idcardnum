package com.miooim;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdCardNumGenerateTest {

    @Test
    void generate() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(new IdCardNumGenerate().generate());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "/ms");
    }
}