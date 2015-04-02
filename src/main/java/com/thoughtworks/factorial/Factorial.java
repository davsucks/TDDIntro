package com.thoughtworks.factorial;

public class Factorial {
    public Integer compute(int i) {
        if (i == 0) {
            return 1;
        } else if (i <= 2) {
            return i;
        }
        return compute(i - 1) + compute(i - 2);
    }
}
