package com.pch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static int[] generate(int length) {
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = ThreadLocalRandom.current().nextInt(length);
        }
        return ints;
    }

    public static  List<Integer> generateList(int length) {
        List<Integer> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add(ThreadLocalRandom.current().nextInt(length));
        }
        return list;
    }
}
