package com.thoughtworks.util;

import java.math.BigDecimal;

public class Utils {
    public static String dealDoule(double d) {
        String s = new BigDecimal(d).stripTrailingZeros().toPlainString();
        return s;
    }
}
