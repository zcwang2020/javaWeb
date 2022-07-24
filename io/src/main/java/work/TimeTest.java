/**
 * @(#)TimeTest.java, 2022/3/31.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package work;

import java.math.BigDecimal;
import java.util.Date;

import util.DateUtils;

/**
 * @Author zcwang
 * @Date 2022/3/31
 */
public class TimeTest {
    public static void main(String[] args) {
        System.out.println(DateUtils.getStartTimeInMillis(new Date()));

        System.out.println(DateUtils.lastDate());

        long startTimeInMillis = DateUtils
            .getStartTimeInMillis(DateUtils.parseStringToLong("2022-03-31", DateUtils.DATE_FORMAT));
        long endTimeInMillis = DateUtils
            .getEndTimeInMillis(DateUtils.parseStringToDate("2022-03-31", DateUtils.DATE_FORMAT));
        System.out.println("startTimeInMillis=" + startTimeInMillis);
        System.out.println("endTimeInMillis" + endTimeInMillis);

        long currentTime = DateUtils.getCurrentTime();
        System.out.println(DateUtils.parseLongToString(currentTime, DateUtils.DATE_FORMAT));

        System.out.println("date to string:" + DateUtils.parseDateToString(new Date(), DateUtils.DATEFORMAT));

        System.out.println("getStartTime" + DateUtils.getStartTime(new Date()));
        System.out.println(BigDecimal.valueOf(2.00).longValue());
        /*
         * Date date = DateUtils.parseStringToDate("2022-04-17", DateUtils.DATE_FORMAT); long mondayTime =
         * DateUtils.getStartTimeOfWeek(new Date()) - 1; System.out.println("mondayTime:" + mondayTime);
         * System.out.println("mondayTimeDate" + DateUtils.parseLongToString(mondayTime, DateUtils.DATE_FORMAT)); String
         * cJson =
         * "{\"calendar\":[{\"date\":\"2022-04-04\",\"id\":1,\"itemGroup\":62279,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/16492143305287aa.jpg\",\"remark\":\"把生活过得热气腾腾的人，/n最懂藏在红色里的生机与火热。\",\"signInIntegral\":1,\"subject\":\"红色\"},{\"date\":\"2022-04-05\",\"id\":2,\"itemGroup\":62283,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/16492520904a7932.png\",\"remark\":\"明前头采的龙井是限量的，/n但碧绿的春光无限，不妨多看几眼。\",\"signInIntegral\":1,\"subject\":\"绿色\"},{\"date\":\"2022-04-06\",\"id\":3,\"itemGroup\":62286,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/16492143501105ea.jpg\",\"remark\":\"不惧怕成为耀眼的中心，/n成为永不熄灭的小小太阳吧。\",\"signInIntegral\":1,\"subject\":\"黄色\"},{\"date\":\"2022-04-07\",\"id\":4,\"itemGroup\":62284,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/16492143583029b2.jpg\",\"remark\":\"旧了的白T，依然要洗干净再穿，/n前路再远，也不能忘记为何出发。\",\"signInIntegral\":1,\"subject\":\"白色\"},{\"date\":\"2022-04-08\",\"id\":5,\"itemGroup\":62287,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/1649214366b0db21.jpg\",\"remark\":\"黑是包容一切的色彩，/n是不被动摇的纯粹。\",\"signInIntegral\":1,\"subject\":\"黑色\"},{\"date\":\"2022-04-09\",\"id\":6,\"itemGroup\":62285,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/1649214380cff535.jpg\",\"remark\":\"今晚枕着蓝色入睡，/n做一个克莱因蓝般温柔的梦。\",\"signInIntegral\":1,\"subject\":\"蓝色\"},{\"date\":\"2022-04-10\",\"id\":7,\"itemGroup\":62282,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/1649214389b31821.jpg\",\"remark\":\"樱花凋谢了仍会再开，/n关于粉色的浪漫，永不落幕。\",\"signInIntegral\":1,\"subject\":\"粉色\"},{\"date\":\"2022-04-11\",\"id\":8,\"itemGroup\":62291,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/1649214397bca5b8.jpg\",\"remark\":\"如同真金坚不可摧，/n金灿灿的晨光总会如约而至。\",\"signInIntegral\":1,\"subject\":\"金色\"},{\"date\":\"2022-04-12\",\"id\":9,\"itemGroup\":62288,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/1649214417b5d4eb.jpg\",\"remark\":\"木头的纹理，是大自然写给人类，/n不会变质的情书。\",\"signInIntegral\":1,\"subject\":\"棕色\"},{\"date\":\"2022-04-13\",\"id\":10,\"itemGroup\":62299,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/1649214409763af2.jpg\",\"remark\":\"吃下一口鲜甜水灵的春日滋味，/n生活由此明亮起来。\",\"signInIntegral\":1,\"subject\":\"橙色\"},{\"date\":\"2022-04-14\",\"id\":11,\"itemGroup\":62675,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/1649398412f2c268.jpg\",\"remark\":\"新的一天以寓意着幸运的红色开场，/n祈愿美好时常发生。\",\"signInIntegral\":1,\"subject\":\"红色\"},{\"date\":\"2022-04-15\",\"id\":12,\"itemGroup\":62676,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/164939842903a0e4.jpg\",\"remark\":\"为自己种下一片小森林，绿意滋长，/n生命蓬勃向上。\",\"signInIntegral\":1,\"subject\":\"绿色\"},{\"date\":\"2022-04-16\",\"id\":13,\"itemGroup\":62677,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/1649398484b32059.jpg\",\"remark\":\"任世界多么鲜艳，/n灰色仍然保留不过时的高级和低调。\",\"signInIntegral\":1,\"subject\":\"灰色\"},{\"date\":\"2022-04-17\",\"id\":14,\"itemGroup\":62678,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/1649398496c8bed9.jpg\",\"remark\":\"如果长时间凝视紫色，/n你会得到整个宇宙的浪漫。\",\"signInIntegral\":1,\"subject\":\"紫色\"},{\"date\":\"2022-04-18\",\"id\":15,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/1649398515d8438c.jpg\",\"remark\":\"生命的初始，是白色的画卷，任你涂抹所有颜色。\",\"signInIntegral\":1,\"subject\":\"白色\"},{\"date\":\"2022-04-19\",\"id\":16,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/1649398526602f5c.jpg\",\"remark\":\"天气晴好的傍晚，夕阳像一颗大蛋黄，/n黄色光晕温柔了归家的人。\",\"signInIntegral\":1,\"subject\":\"黄色\"},{\"date\":\"2022-04-20\",\"id\":17,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/1649398535138a36.jpg\",\"remark\":\"《布达佩斯大饭店》打造的粉色世界，/n让粉有了电影般的美感。\",\"signInIntegral\":1,\"subject\":\"粉色\"},{\"date\":\"2022-04-21\",\"id\":18,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/1649398546b1b135.jpg\",\"remark\":\"去海边，看蔚蓝无际的海洋，/n一切烦心事啊，都被浪花打散。\",\"signInIntegral\":1,\"subject\":\"蓝色\"},{\"date\":\"2022-04-22\",\"id\":19,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/1649398600616017.jpg\",\"remark\":\"保持热情，保持旺盛的好奇心，/n生活总会带来红色的果实。\",\"signInIntegral\":1,\"subject\":\"红色\"},{\"date\":\"2022-04-23\",\"id\":20,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/164939861268ed54.jpg\",\"remark\":\"趁着春天，让眼睛吸饱浓烈的绿，/n以此抵御不可避免的疲惫与庸常。\",\"signInIntegral\":1,\"subject\":\"绿色\"},{\"date\":\"2022-04-24\",\"id\":21,\"picUrl\":\"https://yanxuan.nosdn.127.net/static-union/1649398622353d07.jpg\",\"remark\":\"不必担心黑夜太长，/n无数的酒和故事，足以点亮整个夜晚。\",\"signInIntegral\":1,\"subject\":\"黑色\"}],\"schemaId\":1}";
         * MaterialBO materialBO = JSON.parseObject(cJson,MaterialBO.class); List<CalendarBO> nowWeeks =
         * materialBO.getCalendar().stream() .filter(m -> DateUtils.parseStringToLong(m.getDate(),
         * DateUtils.DATE_FORMAT) >= mondayTime && DateUtils .parseStringToLong(m.getDate(), DateUtils.DATE_FORMAT) <=
         * mondayTime + DateUtils.TIME_OF_WEEK) .collect(Collectors.toList());
         * System.out.println(JSON.toJSONString(nowWeeks));
         */

        System.out.println("parseLongToString" + DateUtils.parseLongToString(currentTime, DateUtils.DATEFORMAT));

        long startTimeOfWeek = DateUtils.getStartTimeOfWeek(new Date());
        System.out.println("startTimeOfWeek:" + startTimeOfWeek);
    }
}
