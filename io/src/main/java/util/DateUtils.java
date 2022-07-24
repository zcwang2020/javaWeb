package util;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author jmt
 * @Date 2021/6/7
 */
public class DateUtils {

    public static final String DATETIMEFORMAT = "yyyyMMddHHmmss";

    public static final String DATEFORMAT = "yyyyMMdd";

    public static final String DATEHOURFORMAT = "yyyyMMddHH";

    public static final String DATE_UTC = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATE_FORMAT_POINT = "yyyy.MM.dd";

    public static final long TIME_OF_SECOND = 1000L;

    public static final long TIME_OF_MINUTE = 60000L;

    public static final long TIME_OF_HOUR = 3600000L;

    public static final long TIME_OF_DAY = 86400000L;

    public static final long TIME_OF_WEEK = 604800000L;

    /**
     * 获取当前的时间
     */
    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    /**
     * 将[日期]按照给定的[日期格式]转成[字符串]
     *
     * @param date
     *            日期
     * @param format
     *            日期格式
     * @return
     */
    public static String parseDateToString(Date date, String format) {
        if (date == null) {
            return null;
        }
        if (StringUtils.isBlank(format)) {
            format = DATE_TIME_FORMAT;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 获取前一天的日期字符串
     * @return
     */
    public static String lastDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date time = calendar.getTime();
        return parseDateToString(time, DATEFORMAT);
    }

    /**
     * 将[时间]按照指定的[日期格式]转成[字符串]
     *
     * @param time
     *            时间
     * @param format
     *            日期格式
     * @return
     */
    public static String parseLongToString(long time, String format) {
        SimpleDateFormat mydate = new SimpleDateFormat(format);
        return mydate.format(new Date(time));
    }

    /**
     * 转utc时间
     *
     * @param time
     * @return
     */
    public static String parseToUtc(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_UTC);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(new Date(time));
    }

    /**
     * 将[字符串]按照指定的[日期格式]转成[时间]
     *
     * @param time
     *            字符串
     * @param format
     *            日期格式
     * @return
     */
    public static long parseStringToLong(String time, String format) {
        SimpleDateFormat mydate = new SimpleDateFormat(format);
        try {
            Date date = mydate.parse(time);
            if (date != null) {
                return date.getTime();
            }
        } catch (ParseException e) {
        }
        return 0;
    }

    /**
     * 将[字符串]按照指定的[日期格式]转成[日期]
     *
     * @param time
     *            字符串
     * @param format
     *            日期格式
     * @return
     */
    public static Date parseStringToDate(String time, String format) {
        SimpleDateFormat mydate = new SimpleDateFormat(format);
        try {
            Date date = mydate.parse(time);
            if (date != null) {
                return date;
            }
        } catch (ParseException e) {
        }
        return null;
    }

    /**
     * 添加天数
     *
     * @param date
     *            日期
     * @param amount
     *            增加天数
     * @return
     */
    public static Date addDay(Date date, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.DAY_OF_MONTH, amount);

        return calendar.getTime();
    }

    /**
     * 获取某天的开始时间
     *
     * @param date
     *            日期
     */
    public static Date getStartTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取某天零点的时间戳 xxxx-xx-xx 00:00:00:000
     *
     * @param date
     *            日期
     */
    public static long getStartTimeInMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取某天的结束时间戳，xxxx-xx-xx 23：59：59
     *
     * @param date
     *            日期
     */
    public static Long getEndTimeInMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTimeInMillis();
    }

    public static long getStartTimeInMillis(long time) {
        return getStartTimeInMillis(new Date(time));
    }

    /**
     * 获取某天的结束时间
     *
     * @param date
     *            日期
     */
    public static Date getEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取某天的结束时间前一秒
     * <p>
     * 预留到最后一秒
     *
     * @param date
     *            日期
     */
    public static Date getEndTimeWithLastSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取某天的结束时间前N秒
     * <p>
     * 预留到最后N秒
     *
     * @param date
     *            日期
     */
    public static Date getEndTimeWithLastSecond(Date date, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 60 - second);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前时间在一天中的分钟数
     *
     * @param c
     * @return
     */
    public static int getCurrentMinutesOfDay(Calendar c) {
        // 获取当前小时数
        int hour = c.get(Calendar.HOUR_OF_DAY);
        // 获取当前小时的分钟数
        int minute = c.get(Calendar.MINUTE);
        return hour * 60 + minute;

    }

    /**
     * 获取某天开始的时间戳
     *
     * @param year
     * @param month
     *            0-11
     * @param date
     * @return
     */
    public static long getStartTimeOfDayInMillis(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取某天结束的时间戳
     *
     * @param year
     * @param month
     *            0-11
     * @param date
     * @return
     */
    public static long getEndTimeOfDayInMillis(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取某月开始的时间戳
     *
     * @param year
     * @param month
     *            0-11
     * @return
     */
    public static long getStartTimeOfMonthInMillis(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取某月结束的时间戳
     *
     * @param year
     * @param month
     *            0-11
     * @return
     */
    public static long getEndTimeOfMonthInMillis(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取指定个月后的时间戳
     *
     * @param currentTime
     * @param months
     * @return
     */
    public static long getMonthsDelayTime(long currentTime, int months) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(currentTime);
        c.add(Calendar.MONTH, months);
        return c.getTimeInMillis();
    }

    /**
     * 获取指定个天后的时间戳
     *
     * @param currentTime
     * @param days
     * @return
     */
    public static long getDaysDelayTime(long currentTime, int days) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(currentTime);
        c.add(Calendar.DAY_OF_YEAR, days);
        return c.getTimeInMillis();
    }

    /**
     * 获取指定分钟后的时间戳
     *
     * @param currentTime
     * @param mins
     * @return
     */
    public static long getHoursDelayTime(long currentTime, int mins) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(currentTime);
        c.add(Calendar.HOUR_OF_DAY, mins);
        return c.getTimeInMillis();
    }

    /**
     * 获取指定分钟后的时间戳
     *
     * @param currentTime
     * @param mins
     * @return
     */
    public static long getMinutesDelayTime(long currentTime, int mins) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(currentTime);
        c.add(Calendar.MINUTE, mins);
        return c.getTimeInMillis();
    }

    /**
     * 获取指定时间的星期一
     *
     * @param date
     * @return
     */
    public static long getStartTimeOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取指定时间剩余毫秒数 工具类：[日期]、[字符串]、[时间]三者的转换工具类
     * <p>
     * 三者的转换是非常常用的，所以定义此工具类。三者的简要说明如下：
     * <li>[日期]：日期对象
     * <li>[字符串]：指的是日期的字符串表示
     * <li>[时间]：long型的值
     * 
     * @param date
     * @return
     */
    public static long getLeftTimeMilesForDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis() - date.getTime();
    }

    /**
     * 获取指定时间+mins分钟后的整分时间
     *
     * @param currentTime
     * @param mins
     * @return
     */
    public static long getStartTimeOfMinitue(long currentTime, int mins) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(currentTime);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.MINUTE, mins);
        return c.getTimeInMillis();
    }

    public static Date getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    public static void main(String[] args) {
        System.out.println(parseStringToLong("20170331110100", DATETIMEFORMAT));
    }
}
