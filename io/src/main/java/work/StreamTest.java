/**
 * @(#)StreamTest.java, 2022/5/11.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package work;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

/**
 * @Author zcwang
 * @Date 2022/5/11
 */
public class StreamTest {
    public static void main(String[] args) {
        /*
         * List<Integer> testData = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9); Optional<Integer> sum =
         * testData.stream().collect(Collectors.reducing((prev, cur) -> { System.out.println("prev=>" + prev + "cur=>" +
         * cur); return prev + cur; })); System.out.println((sum.get()));
         */

        /*
         * List<Integer> list = Arrays.asList(1, 2, 3, 4); Double result =
         * list.stream().collect(Collectors.collectingAndThen(Collectors.averagingLong(v -> { System.out.println("v--" +
         * v + "--> " + v * 2); return v * 2; }), s -> { System.out.println("s--" + s + "--> " + s * s); return s * s;
         * })); System.out.println(result);
         */

        List<Student> students = new ArrayList<>();
        // 创建几个对象放在list集合中
        students.add(new Student().setName("a").setClassId(1).setRank(3));
        students.add(new Student().setName("b").setClassId(1).setRank(1));
        students.add(new Student().setName("c").setClassId(3).setRank(2));
        students.add(new Student().setName("d").setClassId(2).setRank(1));
        students.add(new Student().setName("e").setClassId(2).setRank(2));
        students.add(new Student().setName("f").setClassId(3).setRank(3));
        students.add(new Student().setName("g").setClassId(2).setRank(3));
        students.add(new Student().setName("h").setClassId(3).setRank(1));
        students.add(new Student().setName("i").setClassId(1).setRank(2));

        List<Map.Entry<Integer, List<Student>>> collect = students.stream()
            .collect(Collectors.groupingBy(Student::getClassId)).entrySet().stream().map(entry -> {
                List<Student> studentList = entry.getValue();
                studentList = studentList.stream().sorted(Comparator.comparing(Student::getRank)).limit(2)
                    .collect(Collectors.toList());
                entry.setValue(studentList);
                return entry;
            }).collect(Collectors.toList());
        // 期望值，1：b,i;2:d,e;3:h,c;
        System.out.println(JSON.toJSONString(collect));
    }
}
