package com.example.news.util.opslabJutil.helper;


import com.example.news.util.opslabJutil.Opslab;

import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 提供一些常用的时间想法的方法
 */
public final class DateHelper {


    private static DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern(Opslab.DATETIME_FORMAT);
    private static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern(Opslab.DATE_FORMAT);
    private static DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern(Opslab.TIME_FORMAT);

    public static final Pattern PATTERN_DATETIME_BURST = Pattern.compile("^\\d{2}:\\d{2}:\\d{2}-\\d{2}:\\d{2}:\\d{2}");


    /**
     * LocalDate 转 Date
     */
    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDateTime 转 Date
     */
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * Date 转 LocalDate
     * @param date
     * @return
     */
    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Date 转 LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * Date 转 localDate
     */
    public static LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        LocalDate localDate = zdt.toLocalDate();
        return localDate;
    }

    /**
     * instant 转 date
     *
     * @param instant
     * @return
     */
    public static Date Instan2Date(Instant instant) {
        try {
            return new Date(instant.toEpochMilli());
        } catch (ArithmeticException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    /**
     * 获取当前日期时间
     *
     * @return 返回当前时间的字符串值
     */
    public static String currentDateTime() {
        return DATETIME_FORMAT.format(Instant.now());
    }

    /**
     * 将指定的时间格式化成出返回
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return DATETIME_FORMAT.format(date.toInstant());
    }
    public static String format(LocalDateTime date) {
        return DATETIME_FORMAT.format(date);
    }
    /**
     * 格式化日期
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        return DATE_FORMAT.format(date.toInstant());
    }
    public static String formatDate(LocalDate date) {
        return DATE_FORMAT.format(date);
    }


    /**
     * 格式化时间
     * @param date
     * @return
     */
    public static String formatTime(Date date) {
        return TIME_FORMAT.format(date.toInstant());
    }
    public static String formatTime(LocalTime date) {
        return TIME_FORMAT.format(date);
    }

    /**
     * 将指定的字符串解析为时间类型
     *
     * @param datestr
     * @return
     * @throws ParseException
     */
    public static Date dateTime(String datestr)  {
        return asDate(LocalDateTime.parse(datestr, DATETIME_FORMAT));
    }


    /**
     * 获取当前的日期
     *
     * @return
     */
    public static String currentDate() {
        return DATE_FORMAT.format(Instant.now());
    }



    /**
     * 将指定的字符串解析为时间类型
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static LocalDate date(String dateStr) throws ParseException {
        return LocalDate.parse(dateStr, DATE_FORMAT);
    }

    /**
     * 获取当前的时间
     *
     * @return
     */
    public static String currentTime() {
        return TIME_FORMAT.format(Instant.now());
    }



    /**
     * 将指定的字符串解析为时间类型
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date time(String dateStr) {
        return asDate(LocalDateTime.parse(dateStr, TIME_FORMAT));

    }


    /**
     * 在当前时间的基础上加或减去year年
     *
     * @param year
     * @return
     */
    public static Date year(int year) {
        Calendar Cal = Calendar.getInstance();
        Cal.setTime(new Date());
        Cal.add(Calendar.YEAR, year);
        return Cal.getTime();
    }

    /**
     * 在指定的时间上加或减去几年
     *
     * @param date
     * @param year
     * @return
     */
    public static Date year(Date date, int year) {
        Calendar Cal = Calendar.getInstance();
        Cal.setTime(date);
        Cal.add(Calendar.YEAR, year);
        return Cal.getTime();
    }

    /**
     * 在当前时间的基础上加或减去几月
     *
     * @param month
     * @return
     */
    public static Date month(int month) {
        Calendar Cal = Calendar.getInstance();
        Cal.setTime(new Date());
        Cal.add(Calendar.MONTH, month);
        return Cal.getTime();
    }

    /**
     * 在指定的时间上加或减去几月
     *
     * @param date
     * @param month
     * @return
     */
    public static Date month(Date date, int month) {
        Calendar Cal = Calendar.getInstance();
        Cal.setTime(date);
        Cal.add(Calendar.MONTH, month);
        return Cal.getTime();
    }

    /**
     * 在当前时间的基础上加或减去几天
     *
     * @param day
     * @return
     */
    public static Date day(int day) {
        Calendar Cal = Calendar.getInstance();
        Cal.setTime(new Date());
        Cal.add(Calendar.DAY_OF_YEAR, day);
        return Cal.getTime();
    }

    /**
     * 在指定的时间上加或减去几天
     *
     * @param date
     * @param day
     * @return
     */
    public static Date day(Date date, int day) {
        Calendar Cal = Calendar.getInstance();
        Cal.setTime(date);
        Cal.add(Calendar.DAY_OF_YEAR, day);
        return Cal.getTime();
    }

    /**
     * 在当前时间的基础上加或减去几小时-支持浮点数
     *
     * @param hour
     * @return
     */
    public static Date hour(float hour) {
        Calendar Cal = Calendar.getInstance();
        Cal.setTime(new Date());
        Cal.add(Calendar.MINUTE, (int) (hour * 60));
        return Cal.getTime();
    }

    /**
     * 在制定的时间上加或减去几小时-支持浮点数
     *
     * @param date
     * @param hour
     * @return
     */
    public static Date hour(Date date, float hour) {
        Calendar Cal = Calendar.getInstance();
        Cal.setTime(date);
        Cal.add(Calendar.MINUTE, (int) (hour * 60));
        return Cal.getTime();
    }

    /**
     * 在当前时间的基础上加或减去几分钟
     *
     * @param minute
     * @return
     */
    public static Date minute(int minute) {
        Calendar Cal = Calendar.getInstance();
        Cal.setTime(new Date());
        Cal.add(Calendar.MINUTE, minute);
        return Cal.getTime();
    }

    /**
     * 在制定的时间上加或减去几分钟
     *
     * @param date
     * @param minute
     * @return
     */
    public static Date minute(Date date, int minute) {
        Calendar Cal = Calendar.getInstance();
        Cal.setTime(date);
        Cal.add(Calendar.MINUTE, minute);
        return Cal.getTime();
    }


    /**
     * 判断字符串是否为日期字符串
     *
     * @param date 日期字符串
     * @return true or false
     */
    public static boolean isDate(String date) {
        try {
            DATETIME_FORMAT.parse(date);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 时间date1和date2的时间差-单位秒
     *
     * @param date1
     * @param date2
     * @return 秒
     */
    public static long subtract(Date date1, Date date2) {
        long cha = (date2.getTime() - date1.getTime()) / 1000;
        return cha;
    }

    /**
     * 时间date1和date2的时间差-单位秒
     *
     * @param date1
     * @param date2
     * @return 秒
     */
    public static long subtract(String date1, String date2) {
        long rs = 0l;
        try {
            LocalDateTime start = LocalDateTime.parse(date1, DATETIME_FORMAT);
            LocalDateTime end = LocalDateTime.parse(date2, DATETIME_FORMAT);
            Duration duration =Duration.between(end, start);
            rs =  Math.abs(duration.getSeconds());
        } catch (Exception e) {
            rs = -1;
            e.printStackTrace();
        }
        return rs;
    }


    /**
     * 时间date1和date2的时间差 -单位分钟
     *
     * @param date1
     * @param date2
     * @return 分钟
     */
    public static long subtractMinute(String date1, String date2) {
        long rs = subtract(date1, date2);
        if (rs > 0) {
            return rs / 60;
        }
        return rs;
    }

    /**
     * 时间date1和date2的时间差-单位分钟
     *
     * @param date1
     * @param date2
     * @return 分钟
     */
    public static int subtractMinute(Date date1, Date date2) {
        long cha = date2.getTime() - date1.getTime();
        return (int) cha / (1000 * 60);
    }

    /**
     * 时间date1和date2的时间差-单位小时
     *
     * @param date1
     * @param date2
     * @return 小时
     */
    public static int subtractHour(Date date1, Date date2) {
        long cha = (date2.getTime() - date1.getTime()) / 1000;
        return (int) cha / (60 * 60);
    }

    /**
     * 时间date1和date2的时间差-单位小时
     *
     * @param date1
     * @param date2
     * @return 小时
     */
    public static long subtractHour(String date1, String date2) {
        long rs = subtract(date1, date2);
        if (rs > 0) {
            return rs / 3600;
        }
        return rs;
    }


    /**
     * 时间date1和date2的时间差-单位天
     *
     * @param date1
     * @param date2
     * @return 天
     */
    public static long subtractDay(String date1, String date2) {
        long rs = subtract(date1, date2);
        if (rs > 0) {
            return rs / 86400;
        }
        return rs;
    }

    /**
     * 时间date1和date2的时间差-单位天
     *
     * @param date1
     * @param date2
     * @return 天
     */
    public static int subtractDay(Date date1, Date date2) {
        long cha = date2.getTime() - date1.getTime();
        return (int) cha / (1000 * 60 * 60 * 24);
    }

    /**
     * 时间date1和date2的时间差-单位月
     *
     * @param date1
     * @param date2
     * @return 月
     */
    public static int subtractMonth(String date1, String date2) {
        int result;
        try {
            LocalDate start = LocalDate.parse(date1, DATE_FORMAT);
            LocalDate end = LocalDate.parse(date2, DATE_FORMAT);
            int year1 = start.getYear();
            int month1 = start.getMonthValue();
            int year2 = end.getYear();
            int month2 = end.getMonthValue();
            if (year1 == year2) {
                result = month2 - month1;
            } else {
                result = 12 * (year2 - year1) + month2 - month1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        }
        return result;
    }

    /**
     * 时间date1和date2的时间差-单位月
     *
     * @param date1
     * @param date2
     * @return 月
     */
    public static int subtractMonth(Date date1, Date date2) {
        int result;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        int year1 = c1.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH);
        if (year1 == year2) {
            result = month2 - month1;
        } else {
            result = 12 * (year2 - year1) + month2 - month1;
        }
        return result;
    }

    /**
     * 时间date1和date2的时间差-单位年
     *
     * @param date1
     * @param date2
     * @return 年
     */
    public static int subtractYear(String date1, String date2) {
        int result;
        try {
            LocalDate start = LocalDate.parse(date1, DATE_FORMAT);
            LocalDate end = LocalDate.parse(date2, DATE_FORMAT);
            int year1 = start.getYear();
            int year2 = end.getYear();
            result = year2 - year1;
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        }
        return result;
    }

    /**
     * 时间date1和date2的时间差-单位年
     *
     * @param date1
     * @param date2
     * @return 年
     */
    public static int subtractYear(Date date1, Date date2) {
        int result;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        result = year2 - year1;
        return result;
    }

    /**
     * 获取俩个时间的差结果用时秒表示
     *
     * @param date1
     * @param date2
     * @return 几小时:几分钟:几秒钟
     * @Summary:此处可以讲计算结果包装成一个结构体返回便于格式化
     */
    public static String subtractTime(String date1, String date2) {
        String result = "";
        try {
            long sss = subtract(date1, date2);
            int hh = (int) sss / (60 * 60);
            int mm = (int) (sss - hh * 60 * 60) / (60);
            int ss = (int) (sss - hh * 60 * 60 - mm * 60);
            result = hh + ":" + mm + ":" + ss;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取俩个时间的查结果用时秒表示
     *
     * @param date1
     * @param date2
     * @return 几天-几小时:几分钟:几秒钟
     * @Summary:此处可以讲计算结果包装成一个结构体返回便于格式化
     */
    public static String subtractDate(String date1, String date2) {
        String result = "";
        try {
            long sss = subtract(date1, date2);
            int dd = (int) sss / (60 * 60 * 24);
            int hh = (int) (sss - dd * 60 * 60 * 24) / (60 * 60);
            int mm = (int) (sss - dd * 60 * 60 * 24 - hh * 60 * 60) / (60);
            int ss = (int) (sss - dd * 60 * 60 * 24 - hh * 60 * 60 - mm * 60);
            result = dd + "-" + hh + ":" + mm + ":" + ss;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取俩个时间之前的相隔的天数
     *
     * @param startTime
     * @param endTime
     * @return
     * @throws ParseException
     */
    public static int subDay(Date startTime, Date endTime) {
        int days = 0;
        Calendar can1 = Calendar.getInstance();
        can1.setTime(startTime);
        Calendar can2 = Calendar.getInstance();
        can2.setTime(endTime);
        int year1 = can1.get(Calendar.YEAR);
        int year2 = can2.get(Calendar.YEAR);

        Calendar can = null;
        if (can1.before(can2)) {
            days -= can1.get(Calendar.DAY_OF_YEAR);
            days += can2.get(Calendar.DAY_OF_YEAR);
            can = can1;
        } else {
            days -= can2.get(Calendar.DAY_OF_YEAR);
            days += can1.get(Calendar.DAY_OF_YEAR);
            can = can2;
        }
        for (int i = 0; i < Math.abs(year2 - year1); i++) {
            days += can.getActualMaximum(Calendar.DAY_OF_YEAR);
            can.add(Calendar.YEAR, 1);
        }

        return days;
    }

    /**
     * 获取俩个时间之前的相隔的天数
     *
     * @param startTime
     * @param endTime
     * @return
     * @throws ParseException
     */
    public static int subDay(String startTime, String endTime) {
        int days = 0;
        try {
            Date date1 = asDate(LocalDateTime.parse(startTime, DATETIME_FORMAT));
            Date date2 = asDate(LocalDateTime.parse(endTime, DATETIME_FORMAT));
            Calendar can1 = Calendar.getInstance();
            can1.setTime(date1);
            Calendar can2 = Calendar.getInstance();
            can2.setTime(date2);
            int year1 = can1.get(Calendar.YEAR);
            int year2 = can2.get(Calendar.YEAR);

            Calendar can = null;
            if (can1.before(can2)) {
                days -= can1.get(Calendar.DAY_OF_YEAR);
                days += can2.get(Calendar.DAY_OF_YEAR);
                can = can1;
            } else {
                days -= can2.get(Calendar.DAY_OF_YEAR);
                days += can1.get(Calendar.DAY_OF_YEAR);
                can = can2;
            }
            for (int i = 0; i < Math.abs(year2 - year1); i++) {
                days += can.getActualMaximum(Calendar.DAY_OF_YEAR);
                can.add(Calendar.YEAR, 1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            days = -1;
        }
        return days;
    }

    /**
     * 返回俩个时间在时间段(例如每天的08:00-18:00)的时长-单位秒
     *
     * @param startDate
     * @param endDate
     * @param timeBurst 只就按该时间段内的08:00-18:00时长
     * @return 计算后的秒数
     * @throws ParseException
     * @summary 格式错误返回0
     */
    //public static long subtimeBurst(String startDate, String endDate, String timeBurst)
    //        throws ParseException {
    //    LocalDateTime start = LocalDateTime.parse(startDate, DATETIME_FORMAT);
    //    LocalDateTime end = LocalDateTime.parse(endDate, DATETIME_FORMAT);
    //    return subtimeBurst(asDate(start), asDate(end), timeBurst);
    //}

    /**
     * 返回俩个时间在时间段(例如每天的08:00:00-18:00:00)的时长-单位秒
     *
     * @param startDate
     * @param endDate
     * @param timeBurst 只就按该时间段内的08:00:00-18:00:00时长
     * @return 计算后的秒数
     * @throws ParseException
     */
    //public static long subtimeBurst(Date startDate, Date endDate, String timeBurst) {
    //    Matcher m = PATTERN_DATETIME_BURST.matcher(timeBurst);
    //    if(!m.matches()){
    //        return  -1;
    //    }
    //    String[] a = timeBurst.split("-");
    //    LocalTime startBurst = LocalTime.parse(a[0],TIME_FORMAT);
    //    LocalTime endBurst = LocalTime.parse(a[0],TIME_FORMAT);
    //    long burstSeconds = Duration.between(endBurst, startBurst).getSeconds();
    //    if(burstSeconds <=0){
    //        return -1;
    //    }
    //
    //
    //        int day = subDay(startDate, endDate);
    //        if (day > 0) {
    //            long firstMintues = 0;
    //            long lastMintues = 0;
    //            long daySecond = 0;
    //
    //            //daySecond = subtract(dayStart, dayEnd);
    //            //if ((startDate.after(dayStart) || startDate.equals(dayStart))
    //            //        && startDate.before(dayEnd)) {
    //            //    firstMintues = (dayEnd.getTime() - startDate.getTime()) / 1000;
    //            //} else if (startDate.before(dayStart)) {
    //            //    firstMintues = (dayEnd.getTime() - dayStart.getTime()) / 1000;
    //            //}
    //            //dayStart = DATETIME_FORMAT.parse(DATE_FORMAT.format(endDate) + " " + a[0] + ":00");
    //            //dayEnd = DATETIME_FORMAT.parse(DATE_FORMAT.format(endDate) + " " + a[1] + ":00");
    //            //if (endDate.after(dayStart) && (endDate.before(dayEnd) || endDate.equals(dayEnd))) {
    //            //    lastMintues = (endDate.getTime() - dayStart.getTime()) / 1000;
    //            //} else if (endDate.after(dayEnd)) {
    //            //    lastMintues = (dayEnd.getTime() - dayStart.getTime()) / 1000;
    //            //}
    //            //第一天的秒数 + 最好一天的秒数 + 天数*全天的秒数
    //            //second = firstMintues + lastMintues;
    //            //second += (day - 1) * daySecond;
    //        } else {
    //            //Date dayStart = asDate(LocalDateTime.parse(DATE_FORMAT.format(date.toInstant())+" " + a[0] + ":00",
    //            //        DATETIME_FORMAT));
    //            //Date dayEnd = asDate(LocalDateTime.parse(DATE_FORMAT.format(date.toInstant())+" " + a[1] + ":00",
    //            //        DATETIME_FORMAT));
    //            //if ((startDate.after(dayStart) || startDate.equals(dayStart))
    //            //        && startDate.before(dayEnd) && endDate.after(dayStart)
    //            //        && (endDate.before(dayEnd) || endDate.equals(dayEnd))) {
    //            //    second = (endDate.getTime() - startDate.getTime()) / 1000;
    //            //} else {
    //            //    if (startDate.before(dayStart)) {
    //            //        if (endDate.before(dayEnd)) {
    //            //            second = (endDate.getTime() - dayStart.getTime()) / 1000;
    //            //        } else {
    //            //            second = (dayEnd.getTime() - dayStart.getTime()) / 1000;
    //            //        }
    //            //    }
    //            //    if (startDate.after(dayStart)) {
    //            //        if (endDate.before(dayEnd)) {
    //            //            second = (endDate.getTime() - startDate.getTime()) / 1000;
    //            //        } else {
    //            //            second = (dayEnd.getTime() - startDate.getTime()) / 1000;
    //            //        }
    //            //    }
    //            //}
    //            //if ((startDate.before(dayStart) && endDate.before(dayStart))
    //            //        || startDate.after(dayEnd) && endDate.after(dayEnd)) {
    //            //    second = 0;
    //            //}
    //        }
    //
    //
    //    return -1;
    //}

    /**
     * 时间Date在时间段(例如每天的08:00:00-18:00:00)上增加或减去second秒
     *
     * @param date
     * @param second
     * @param timeBurst
     * @return 计算后的时间
     * @Suumary 指定的格式错误后返回原数据
     */
    public static LocalDateTime calculate(String date, int second, String timeBurst) {
        LocalDateTime startTime = LocalDateTime.parse(date, DATETIME_FORMAT);
        return calculate(startTime, second, timeBurst);
    }

    /**
     * 时间Date在时间段(例如每天的08:00:00-18:00:00)上增加或减去second秒
     *
     * @param date
     * @param second
     * @param timeBurst
     * @return 计算后的时间
     * @Suumary 指定的格式错误后返回原数据
     */
    public static LocalDateTime calculate(LocalDateTime date, int second, String timeBurst) {
        Matcher m = PATTERN_DATETIME_BURST.matcher(timeBurst);
        if(!m.matches()){
            throw  new RuntimeException("TimeBurstFormatError");
        }
        String[] a = timeBurst.split("-");
        LocalTime startBurst = LocalTime.parse(a[0],TIME_FORMAT);
        LocalTime endBurst = LocalTime.parse(a[1],TIME_FORMAT);
        //获取时间段相差的秒数
        long burstSeconds = Duration.between(startBurst,endBurst).getSeconds();
        if(burstSeconds <=0){
            throw  new RuntimeException("TimeBurst Invalid time period");
        }



        LocalTime startlocalTime = date.toLocalTime();
        if(startlocalTime.isBefore(startBurst)){
            startlocalTime = startBurst;
        }
        //第一天有效的秒数
        long startDaySeconds = Math.abs(Duration.between(endBurst, startlocalTime).getSeconds());
        if(second  <= startDaySeconds){
            date = date.plusSeconds(second);
            return date;
        }

        long days = (second - startDaySeconds )/burstSeconds;
        date = date.plusDays(days+1);
        date = date.with(startBurst);
        long endDaysSeconds = ((second - startDaySeconds) - startDaySeconds * days) % burstSeconds;
        date = date.plusSeconds(endDaysSeconds);
        return date;
    }

    /**
     * 判断是否在某个时间段内
     *
     * @param startTime
     * @param endTime
     * @param date
     * @return
     * @throws ParseException
     */
    public static boolean between(String startTime, String endTime, Date date){
        try {
            LocalDateTime start = LocalDateTime.parse(startTime, DATETIME_FORMAT);
            LocalDateTime end = LocalDateTime.parse(endTime, DATETIME_FORMAT);
            return between(asDate(start), asDate(end), date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    /**
     * 判断在某个时间内
     *
     * @param startTime
     * @param endTime
     * @param date
     * @return
     */
    public static boolean between(Date startTime, Date endTime, Date date) {
        return date.after(startTime) && date.before(endTime);
    }
}
