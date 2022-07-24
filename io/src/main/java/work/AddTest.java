/**
 * @(#)AddTest.java, 2021/11/29.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package work;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Tmind
 * @Date 2021/11/29
 */
public class AddTest {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.addAll(b);
        System.out.println(a);


        a.add(1);
        a.add(2);
        // 倒叙，由大到小
        List<Integer> collect = a.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).collect(Collectors.toList());
        System.out.println(collect);

        String s = "1311_00000001";
        System.out.println(s.length());

        List<String> dates = new ArrayList<>();
        dates.add("2022-03-01 10:11:12");
        dates.add("2022-03-02");
        dates.add("2022-03-02");
        dates.add("2022-03-04");
        dates.add("2022-03-05");
        dates.add("2022-03-06");
        dates.add("2022-03-07");
        dates.add("2022-03-08");
        dates.add("2022-03-09");

        String d1 = "2022-02-28";
        String d2 = "2022-03-06";
        List<String> collect1 = dates.stream().filter(d -> d.compareTo(d1) >= 0 && d.compareTo(d2) <= 0).collect(Collectors.toList());
        System.out.println(collect1);
        LocalTime now1 = LocalTime.now();
        System.out.println(null == null);

    }

}