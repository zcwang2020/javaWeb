/**
 * @(#)ReplaceTest.java, 2022/2/17.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package work;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author zcwang
 * @Date 2022/2/17
 */
public class ReplaceTest {
    public static void main(String[] args) {
        /*String name = "123";
        System.out.println(name.replaceFirst(name.substring(2), "*"));

        long time = 11L;
        int interval = 1;
        BigDecimal a  = BigDecimal.valueOf(2.4);
        System.out.println(new BigDecimal(time / interval));
        BigDecimal add = a.add(BigDecimal.ONE);
        System.out.println(add);
        System.out.println(new BigDecimal(time * interval).multiply(add));
        System.out.println(new BigDecimal(time * interval).multiply(add).setScale(0, BigDecimal.ROUND_HALF_UP).longValue());

        List<Integer> list1 = new ArrayList<>();
        System.out.println(list1.size());*/

        System.out.println(check());

    }

    private static Integer check() {
        List<Wei> slll = new ArrayList<>();
        Integer start = 68;
        Integer end = 78;
        Integer d = 10;
        slll.add(new Wei("", 50, 10));
        slll.add(new Wei("", 40, 10));
        slll.add(new Wei("", 30, 10));
        slll.add(new Wei("", 60, 10));
        slll.add(new Wei("", 20, 10));
        slll.add(new Wei("", 10, 10));
        List<Wei> collect = slll.stream().sorted(Comparator.comparing(Wei::getAge).reversed()).collect(Collectors.toList());
        Integer days = 0;
        Integer times = 1;
        while (times < 8) {
            for (Wei wei : collect) {
                if (wei.getAge() >= start - d * times && wei.getAge() <= end - d * times) {
                    times += 1;
                    days += 1;
                } else {
                   return days;
                }
            }
        }
        return days;
    }
}