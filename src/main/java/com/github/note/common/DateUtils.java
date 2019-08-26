package com.github.note.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author :Mr.kk(赵宽宽)
 * @E-mail :935068797@qq.com
 * @date: 2018/11/9-11:25
 */
public class DateUtils {
    /**
     * 获取当前日期所在周的周一日期
     * @param date
     * @return String
     * @throws Exception
     */
    public static String getCurWeekBeginDate(String date) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date dat = df.parse(date);
        cal.setTime(dat);
        int curdays = cal.get(Calendar.DAY_OF_WEEK);
        return dateAddDays(date, -curdays + 2);
    }

    /**
     * 获取指定日期后monthNum个月最后一天日期
     * @param date
     * @param monthNum
     *            指定月份数
     * @return String
     * @throws Exception
     */
    public static String getNextMonthLastDay(String date, int monthNum)
            throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date dat = df.parse(date);
        cal.setTime(dat);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        cal.set(Calendar.MONTH, month + monthNum);
        int days = getMonthLastDay(year, month + monthNum + 1);
        cal.set(Calendar.DAY_OF_MONTH, days);
        String endDate = df.format(cal.getTime());
        return endDate;
    }

    /**
     * 获取指定日期monthNum个月后第一天日期
     * @param date
     * @param monthNum
     *            指定月份数
     * @return String
     * @throws Exception
     */
    public static String getNextMonthFirstDay(String date, int monthNum)
            throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date dat = df.parse(date);
        cal.setTime(dat);
        int month = cal.get(Calendar.MONTH);
        cal.set(Calendar.MONTH, month + monthNum);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String endDate = df.format(cal.getTime());
        return endDate;
    }

    /**
     * 获取指定日期下月最后一天日期
     * @param date
     * @return String
     * @throws Exception
     */
    public static String getNextMonthLastDay(String date) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date dat = df.parse(date);
        cal.setTime(dat);
        int month = cal.get(Calendar.MONTH);
        cal.set(Calendar.MONTH, month + 1);
        int year = cal.get(Calendar.YEAR);
        int days = getMonthLastDay(year, month + 2);
        cal.set(Calendar.DAY_OF_MONTH, days);
        String endDate = df.format(cal.getTime());
        return endDate;
    }

    /**
     * 获取指定日期下月第一日期
     * @param date
     * @return String
     * @throws Exception
     */
    public static String getNextMonthFirstDay(String date) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date dat = df.parse(date);
        cal.setTime(dat);
        int month = cal.get(Calendar.MONTH);
        cal.set(Calendar.MONTH, month + 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String endDate = df.format(cal.getTime());
        return endDate;
    }

    /**
     * 取得当月天数
     * @return int
     */
    public static int getCurrentMonthLastDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 得到指定月的天数
     * @param year
     * @param month
     * @return int
     */
    public static int getMonthLastDay(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 计算两个日期之间相差的天数
     * @param smdate
     *            较小的时间
     * @param bdate
     *            较大的时间
     * @return 相差天数 int
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 字符串的日期格式的计算
     * @param smdate
     *            较小的时间
     * @param bdate
     *            较大的时间
     * @return 相差天数 int
     * @throws Exception
     */
    public static int daysBetween(String smdate, String bdate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 比较两个日期字符串大小
     * @param sourceDate
     * @param targetTate
     * @return int
     */
    public static int compareDate(String sourceDate, String targetTate) {
        if ((sourceDate == null || "".equals(sourceDate))
                && (targetTate == null || "".equals(targetTate))) {
            return 0;
        } else if ((sourceDate == null || "".equals(sourceDate))
                && (targetTate != null && !"".equals(targetTate))) {
            return -1;
        } else if ((sourceDate != null && !"".equals(sourceDate))
                && (targetTate == null || "".equals(targetTate))) {
            return 1;
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(sourceDate);
            Date dt2 = df.parse(targetTate);
            if (dt1.getTime() > dt2.getTime()) {
                // System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                // System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取TS字段值
     * @return String
     */
    public static String getTs() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }


    /** 获取当前是当月的第几天
     * @return int
     * @throws Exception
     */
    public static int getCurDateDays() throws Exception {
        return getDaysMonth(getCurDateStr());
    }


    /** 获取当月的第几天
     * @param date
     * @return int
     * @throws Exception
     */
    public static int getDaysMonth(String date) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(format.parse(date));
        int days = cal.get(Calendar.DAY_OF_MONTH);
        return days;
    }

    /** 获取当前的日期
     *  格式:yyyy-MM-dd
     * @return String
     */
    public static String getCurDateStr() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }


    /** 获取当前的月份
     * @return String
     */
    public static String getCurMonthStr() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        return format.format(date);
    }

    /***
     * 将8位的数据日期(yyyyMMdd), 转换成10位(yyyy-MM-dd)
     * @param numDate
     * @return String
     */
    public static String getNormalDate(String numDate) {
        if (numDate == null) {
            return null;
        } else if (numDate.length() != 8) {
            return numDate;
        } else {
            return numDate.substring(0, 4) + "-" + numDate.substring(4, 6)
                    + "-" + numDate.substring(6);
        }
    }


    /**
     * dateAddDays： 对当前日期增加天数
     * @param date
     *            日期
     * @param days
     *            天数
     * @return （参数说明）
     * @throws Exception
     * @exception （异常描述）
     * @see （需要参见的其它内容）
     * @since （从类的那一个版本，此方法被添加进来。（可选））
     */
    public static String dateAddDays(String date, int days) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date dat = df.parse(date);
        cal.setTime(dat);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + days);
        String endDate = df.format(cal.getTime());
        return endDate;
    }

    /**
     * dateAddYear： 给当前年份添加几年
     * @param date
     *            日期
     * @param year
     *            几年
     * @return
     * @throws Exception
     *             （参数说明）
     * @exception （异常描述）
     * @see （需要参见的其它内容）
     * @since （从类的那一个版本，此方法被添加进来。（可选））
     */
    public static String dateAddYear(String date, int year) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dat = df.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dat);
        int temYear = cal.get(Calendar.YEAR);
        int endYear = temYear + year;
        cal.set(Calendar.YEAR, endYear);
        String endDate = df.format(cal.getTime());
        return endDate;
    }

    /**
     * dateAddMoney： 给当前月份加几月
     * @param date
     *            日期
     * @param month
     *            增加月份个数
     * @return
     * @throws Exception
     *             （参数说明）
     * @exception （异常描述）
     * @see （需要参见的其它内容）
     * @since （从类的那一个版本，此方法被添加进来。（可选））
     */
    public static String dateAddMonth(String date, int month) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dat = df.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dat);
        // 开始月份
        int temMonth = cal.get(Calendar.MONTH);
        // 结束月份
        int endMonth = temMonth + month;
        int days = cal.get(Calendar.DATE);
        cal.set(Calendar.MONTH, endMonth);
        String endDate = df.format(cal.getTime());
        cal.setTime(df.parse(endDate));

        endMonth = cal.get(Calendar.MONTH);
        int endDays = cal.get(Calendar.DATE);
        // 开始日期不等于结束日期，对其进行调整 这里没有考虑跨年的情况
        if (days != endDays) {
            if (endMonth == 2) {
                // 这里不区分闰年
                endDays = 28;
            } else {
                endDays = 30;
            }
            cal.set(Calendar.MONTH, endMonth - 1);
            cal.set(Calendar.DATE, endDays);
        }
        endDate = df.format(cal.getTime());
        return endDate;
    }

    /**
     * upDateByMonth： 获取上个月的月末日期
     * @param date
     * @return String
     * @throws Exception
     */
    public static String upDateByMonth(String date) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dat = df.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dat);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        String endDate = df.format(cal.getTime());
        return endDate;
    }


    /** 根据string格式化成Date
     * @param date
     * @return Date
     * @throws Exception
     */
    public static Date getDateByStr(String date) throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.parse(date);
    }


    /** 根据string格式化成Date
     * @param date
     * @return Date
     * @throws Exception
     */
    public static Date getDateByStrings(String date) throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.parse(date);
    }


    /**
     * 取得季度月
     * @param year
     * @return String[]
     * @throws Exception
     */
    public static String[] getSeasonDate(String year,int nSeason) throws Exception {
        String[] seasonday = new  String[2];
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dat = df.parse(year+"-01-01");
        Calendar c = Calendar.getInstance();
        c.setTime(dat);
        if (nSeason == 1) {// 第一季度
            c.set(Calendar.MONTH, Calendar.JANUARY);
            seasonday[0] = getFirstDateOfMonth(c.getTime());
            c.set(Calendar.MONTH, Calendar.MARCH);
            seasonday[1] = getLastDateOfMonth(c.getTime());
        } else if (nSeason == 2) {// 第二季度
            c.set(Calendar.MONTH, Calendar.APRIL);
            seasonday[0] = getFirstDateOfMonth(c.getTime());
            c.set(Calendar.MONTH, Calendar.JUNE);
            seasonday[1] = getLastDateOfMonth(c.getTime());
        } else if (nSeason == 3) {// 第三季度
            c.set(Calendar.MONTH, Calendar.JULY);
            seasonday[0] = getFirstDateOfMonth(c.getTime());
            c.set(Calendar.MONTH, Calendar.SEPTEMBER);
            seasonday[1] = getLastDateOfMonth(c.getTime());
        } else if (nSeason == 4) {// 第四季度
            c.set(Calendar.MONTH, Calendar.OCTOBER);
            seasonday[0] = getFirstDateOfMonth(c.getTime());
            c.set(Calendar.MONTH, Calendar.DECEMBER);
            seasonday[1] = getLastDateOfMonth(c.getTime());
        }
        return seasonday;
    }

    /**
     * 取得月第一天
     * @param date
     * @return String
     */
    public static String getFirstDateOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String firstdate = df.format(c.getTime());
        return firstdate;
    }

    /**
     * 取得月最后一天
     * @param date
     * @return String
     */
    public static String getLastDateOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String lastdate = df.format(c.getTime());
        return lastdate;
    }


    public static void main(String[] args) {
        System.out.println(getCurDateStr());
    }

    ///**
    // * 将yyyy-MM-ddTHH:mm:ss 格式时间转换为yyyy-MM-dd
    // * @param dateStr
    // * @return String
    // */
    //public static String trans2Date(String dateStr){
    //    if(StringUtil.isEmpty(dateStr)){
    //        return null;
    //    }
    //    String format = "yyyy-MM-dd'T'HH:mm:ss";
    //    SimpleDateFormat df = new SimpleDateFormat(format);
    //    Date date = null;
    //    try {
    //        date = df.parse(dateStr);
    //    } catch (ParseException e) {
    //    }
    //    if(date == null){
    //        return null;
    //    }
    //    String destFormat = "yyyy-MM-dd";
    //    df = new SimpleDateFormat(destFormat);
    //    return df.format(date);
    //}

    ///**
    // * 将yyyy-MM-ddTHH:mm:ss 格式时间转换为yyyy-MM-dd HH:mm:ss
    // * @param dateStr
    // * @return String
    // */
    //public static String trans2DateTime(String dateStr){
    //    if(StringUtil.isEmpty(dateStr)){
    //        return null;
    //    }
    //    String format = "yyyy-MM-dd'T'HH:mm:ss";
    //    SimpleDateFormat df = new SimpleDateFormat(format);
    //    Date date = null;
    //    try {
    //        date = df.parse(dateStr);
    //    } catch (ParseException e) {
    //    }
    //    if(date == null){
    //        return null;
    //    }
    //    String destFormat = "yyyy-MM-dd HH:mm:ss";
    //    df = new SimpleDateFormat(destFormat);
    //    return df.format(date);
    //}

}
