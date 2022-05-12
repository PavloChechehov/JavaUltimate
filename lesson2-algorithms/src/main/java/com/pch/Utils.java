package com.pch;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static int[] generate(int length) {
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = ThreadLocalRandom.current().nextInt(length);
        }
        return ints;
    }
}
