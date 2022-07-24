/**
 * @(#)MathTest.java, 2022/5/16.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package work;

import java.math.BigDecimal;

import org.junit.Test;


/**
 * @Author zcwang
 * @Date 2022/5/16
 */
public class MathTest {
    public static void main(String[] args) {
        Integer a = 90;
        Long b = 23L;
        System.out.println(Math.floor(b.intValue() / a));
    }

    @Test
    public void test2() {
        Integer a = 90;
        Long b = 23L;
        System.out.println(new BigDecimal(b).divide(new BigDecimal(a), 2,BigDecimal.ROUND_HALF_UP));
    }
}