package com.thoughtworks.util;

import java.math.BigDecimal;

public class Utils {
    public static String convertDoubleToString(double d) {
        return new BigDecimal(d).stripTrailingZeros().toPlainString();
    }
}
