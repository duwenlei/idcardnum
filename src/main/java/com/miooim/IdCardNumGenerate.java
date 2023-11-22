package com.miooim;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 居民身份证号码生成器
 *
 * @author duwenlei
 * @version 1.0
 * @ClassName IdCardNumGenerate
 * @Date 2023/11/17 11:11
 * @Description TODO
 */
public class IdCardNumGenerate {

    /**
     * 省级行政区代码定义
     */
    private static final HashMap<String, List<String>> REGION_CODE_MAP = new HashMap<String, List<String>>() {
        {
            // 华北地区
            put("1", Stream.of("1", "2", "3", "4", "5").collect(Collectors.toList()));

            // 东北地区
            put("2", Stream.of("1", "2", "3").collect(Collectors.toList()));

            // 华东地区
            put("3", Stream.of("1", "2", "3", "4", "5", "6", "7").collect(Collectors.toList()));

            // 中南地区
            put("4", Stream.of("1", "2", "3", "4", "5", "6").collect(Collectors.toList()));

            // 西南地区
            put("5", Stream.of("0", "1", "2", "3", "4").collect(Collectors.toList()));

            // 西北地区
            put("6", Stream.of("1", "2", "3", "4", "5").collect(Collectors.toList()));

            // 台湾地区
            put("7", Stream.of("1").collect(Collectors.toList()));

            // 港澳台地区
            put("8", Stream.of("1", "2", "3").collect(Collectors.toList()));

            // 外国人永久居留身份证 特殊标识
            put("9", null);
        }
    };

    /**
     * 地级区域代码
     */
    private static final HashMap<String, List<String>> CITY_CODE_MAP = new HashMap<String, List<String>>() {{
        // 1-华北地区
        put("11", Stream.of("01").collect(Collectors.toList()));
        put("12", Stream.of("01").collect(Collectors.toList()));
        put("13", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10").collect(Collectors.toList()));
        put("14", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11").collect(Collectors.toList()));
        put("15", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "22", "25", "29").collect(Collectors.toList()));

        // 2-东北地区
        put("21", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14").collect(Collectors.toList()));
        put("22", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "24").collect(Collectors.toList()));
        put("23", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10").collect(Collectors.toList()));

        // 3-华东地区
        put("31", Stream.of("01").collect(Collectors.toList()));
        put("32", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13").collect(Collectors.toList()));
        put("33", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11").collect(Collectors.toList()));
        put("34", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "10", "11", "12", "13", "15", "16", "17", "18").collect(Collectors.toList()));
        put("35", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09").collect(Collectors.toList()));
        put("36", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11").collect(Collectors.toList()));
        put("37", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "13", "14", "15", "16", "17").collect(Collectors.toList()));

        // 4-中南地区
        put("41", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17").collect(Collectors.toList()));
        put("42", Stream.of("01", "02", "03", "05", "06", "07", "08", "09", "10", "11", "12", "13").collect(Collectors.toList()));
        put("43", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13").collect(Collectors.toList()));
        put("44", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "12", "13", "14", "15", "16", "17", "51", "52", "53").collect(Collectors.toList()));
        put("45", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14").collect(Collectors.toList()));
        put("46", Stream.of("01", "02", "03", "04").collect(Collectors.toList()));

        // 5-西南地区
        put("50", Stream.of("01").collect(Collectors.toList()));
        put("51", Stream.of("01", "03", "04", "05", "06", "07", "08", "09", "10", "11", "13", "14", "15", "16", "17", "18", "19", "20", "32", "33", "34").collect(Collectors.toList()));
        put("52", Stream.of("01", "02", "03", "04", "05", "06", "23", "26", "27").collect(Collectors.toList()));
        put("53", Stream.of("01", "03", "04", "05", "06", "07", "08", "09", "23", "25", "26", "28", "31", "33", "34").collect(Collectors.toList()));
        put("54", Stream.of("01", "02", "03", "04", "05", "06").collect(Collectors.toList()));

        // 6-西北地区
        put("61", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10").collect(Collectors.toList()));
        put("62", Stream.of("01", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "29", "30").collect(Collectors.toList()));
        put("63", Stream.of("01", "02", "22", "23", "25", "26", "27", "28").collect(Collectors.toList()));
        put("64", Stream.of("01", "02", "03", "04", "05").collect(Collectors.toList()));
        put("65", Stream.of("01", "02", "04", "05", "23", "27", "28", "29", "30", "31", "32", "40", "42", "43", "90").collect(Collectors.toList()));

        // 7-台湾地区
        put("71", Stream.of("00").collect(Collectors.toList()));

        // 8-港澳台地区
        put("81", Stream.of("00").collect(Collectors.toList()));
        put("82", Stream.of("00").collect(Collectors.toList()));
        put("83", Stream.of("00").collect(Collectors.toList()));

        // 9-外国人永久居留身份证 特殊标识
    }};

    /**
     * 县级代码
     */
    public static final HashMap<String, List<String>> COUNTY_CODE_MAP = new HashMap<String, List<String>>() {{
        // 北京市
        put("1101", Stream.of("01", "02", "05", "06", "07", "08", "09", "11", "12", "13", "14", "15", "16", "17", "18", "19").collect(Collectors.toList()));

        // 天津市
        put("1201", Stream.of("01", "02", "03", "04", "05", "06", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19").collect(Collectors.toList()));

        // 河北省
        put("1301", Stream.of("02", "04", "05", "07", "08", "09", "10", "11", "21", "23", "25", "26", "27", "28", "29", "30", "31", "32", "33", "81", "83", "84").collect(Collectors.toList()));
        put("1302", Stream.of("02", "03", "04", "05", "07", "08", "09", "24", "25", "27", "29", "81", "83", "84").collect(Collectors.toList()));
        put("1303", Stream.of("02", "03", "04", "06", "21", "22", "24").collect(Collectors.toList()));
        put("1304", Stream.of("02", "03", "04", "06", "07", "08", "23", "24", "25", "26", "27", "30", "31", "32", "33", "34", "35", "81").collect(Collectors.toList()));
        put("1305", Stream.of("02", "03", "05", "06", "22", "23", "24", "25", "28", "29", "30", "31", "32", "33", "34", "35", "81", "82").collect(Collectors.toList()));
        put("1306", Stream.of("02", "06", "07", "08", "09", "23", "24", "26", "27", "28", "30", "31", "33", "34", "35", "36", "37", "81", "82", "83", "84").collect(Collectors.toList()));
        put("1307", Stream.of("02", "03", "05", "06", "08", "09", "22", "23", "24", "25", "26", "27", "28", "30", "31", "32").collect(Collectors.toList()));
        put("1308", Stream.of("02", "03", "04", "21", "22", "24", "25", "26", "27", "28", "81").collect(Collectors.toList()));
        put("1309", Stream.of("02", "03", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "81", "82", "83", "84").collect(Collectors.toList()));
        put("1310", Stream.of("02", "03", "22", "23", "24", "25", "26", "28", "81", "82").collect(Collectors.toList()));
        put("1311", Stream.of("02", "03", "21", "22", "23", "24", "25", "26", "27", "28", "82").collect(Collectors.toList()));
        put("1331", Stream.of("00").collect(Collectors.toList()));

        //山西省
        put("1401", Stream.of("05", "06", "07", "08", "09", "10", "21", "22", "23", "81").collect(Collectors.toList()));
        put("1402", Stream.of("12", "13", "14", "15", "21", "22", "23", "24", "25", "26").collect(Collectors.toList()));
        put("1403", Stream.of("02", "03", "11", "21", "22").collect(Collectors.toList()));
        put("1404", Stream.of("03", "04", "05", "06", "23", "25", "26", "27", "28", "29", "30", "31").collect(Collectors.toList()));
        put("1405", Stream.of("02", "21", "22", "24", "25", "81").collect(Collectors.toList()));
        put("1406", Stream.of("02", "03", "21", "22", "23", "81").collect(Collectors.toList()));
        put("1407", Stream.of("02", "03", "21", "22", "23", "24", "25", "27", "28", "29", "81").collect(Collectors.toList()));
        put("1408", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "81", "82").collect(Collectors.toList()));
        put("1409", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "81").collect(Collectors.toList()));
        put("1410", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "81", "82").collect(Collectors.toList()));
        put("1411", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "81", "82").collect(Collectors.toList()));

        //内蒙古自治区
        put("1501", Stream.of("02", "03", "04", "05", "21", "22", "23", "24", "25").collect(Collectors.toList()));
        put("1502", Stream.of("02", "03", "04", "05", "06", "07", "21", "22", "23").collect(Collectors.toList()));
        put("1503", Stream.of("02", "03", "04").collect(Collectors.toList()));
        put("1504", Stream.of("02", "03", "04", "21", "22", "23", "24", "25", "26", "28", "29", "30").collect(Collectors.toList()));
        put("1505", Stream.of("02", "21", "22", "23", "24", "25", "26", "81").collect(Collectors.toList()));
        put("1506", Stream.of("02", "03", "21", "22", "23", "24", "25", "26", "27").collect(Collectors.toList()));
        put("1507", Stream.of("02", "03", "21", "22", "23", "24", "25", "26", "27", "81", "82", "83", "84", "85").collect(Collectors.toList()));
        put("1508", Stream.of("02", "21", "22", "23", "24", "25", "26").collect(Collectors.toList()));
        put("1509", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "28", "29", "81").collect(Collectors.toList()));
        put("1522", Stream.of("01", "02", "21", "22", "23", "24").collect(Collectors.toList()));
        put("1525", Stream.of("01", "02", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31").collect(Collectors.toList()));
        put("1529", Stream.of("21", "22", "23").collect(Collectors.toList()));

        //辽宁省
        put("2101", Stream.of("02", "03", "04", "05", "06", "11", "12", "13", "14", "15", "23", "24", "81").collect(Collectors.toList()));
        put("2102", Stream.of("02", "03", "04", "11", "12", "13", "14", "24", "81", "83").collect(Collectors.toList()));
        put("2103", Stream.of("02", "03", "04", "11", "21", "23", "81").collect(Collectors.toList()));
        put("2104", Stream.of("02", "03", "04", "11", "21", "22", "23").collect(Collectors.toList()));
        put("2105", Stream.of("02", "03", "04", "05", "21", "22").collect(Collectors.toList()));
        put("2106", Stream.of("02", "03", "04", "24", "81", "82").collect(Collectors.toList()));
        put("2107", Stream.of("02", "03", "11", "26", "27", "81", "82").collect(Collectors.toList()));
        put("2108", Stream.of("02", "03", "04", "11", "81", "82").collect(Collectors.toList()));
        put("2109", Stream.of("02", "03", "04", "05", "11", "21", "22").collect(Collectors.toList()));
        put("2110", Stream.of("02", "03", "04", "05", "11", "21", "81").collect(Collectors.toList()));
        put("2111", Stream.of("02", "03", "04", "22").collect(Collectors.toList()));
        put("2112", Stream.of("02", "04", "21", "23", "24", "81", "82").collect(Collectors.toList()));
        put("2113", Stream.of("02", "03", "21", "22", "24", "81", "82").collect(Collectors.toList()));
        put("2114", Stream.of("02", "03", "04", "21", "22", "81").collect(Collectors.toList()));

        //吉林省
        put("2201", Stream.of("02", "03", "04", "05", "06", "12", "13", "22", "82", "83", "84").collect(Collectors.toList()));
        put("2202", Stream.of("02", "03", "04", "11", "21", "81", "82", "83", "84").collect(Collectors.toList()));
        put("2203", Stream.of("02", "03", "22", "23", "82").collect(Collectors.toList()));
        put("2204", Stream.of("02", "03", "21", "22").collect(Collectors.toList()));
        put("2205", Stream.of("02", "03", "21", "23", "24", "81", "82").collect(Collectors.toList()));
        put("2206", Stream.of("02", "05", "21", "22", "23", "81").collect(Collectors.toList()));
        put("2207", Stream.of("02", "21", "22", "23", "81").collect(Collectors.toList()));
        put("2208", Stream.of("02", "21", "22", "81", "82").collect(Collectors.toList()));
        put("2224", Stream.of("01", "02", "03", "04", "05", "06", "24", "26").collect(Collectors.toList()));

        //黑龙江省
        put("2301", Stream.of("02", "03", "04", "08", "09", "10", "11", "12", "13", "23", "24", "25", "26", "27", "28", "29", "83", "84").collect(Collectors.toList()));
        put("2302", Stream.of("02", "03", "04", "05", "06", "07", "08", "21", "23", "24", "25", "27", "29", "30", "31", "81").collect(Collectors.toList()));
        put("2303", Stream.of("02", "03", "04", "05", "06", "07", "21", "81", "82").collect(Collectors.toList()));
        put("2304", Stream.of("02", "03", "04", "05", "06", "07", "21", "22").collect(Collectors.toList()));
        put("2305", Stream.of("02", "03", "05", "06", "21", "22", "23", "24").collect(Collectors.toList()));
        put("2306", Stream.of("02", "03", "04", "05", "06", "21", "22", "23", "24").collect(Collectors.toList()));
        put("2307", Stream.of("17", "18", "19", "22", "23", "24", "25", "26", "51", "81").collect(Collectors.toList()));
        put("2308", Stream.of("03", "04", "05", "11", "22", "26", "28", "81", "82", "83").collect(Collectors.toList()));
        put("2309", Stream.of("02", "03", "04", "21").collect(Collectors.toList()));
        put("2310", Stream.of("02", "03", "04", "05", "25", "81", "83", "84", "85", "86").collect(Collectors.toList()));
        put("2311", Stream.of("02", "23", "24", "81", "82", "83").collect(Collectors.toList()));
        put("2312", Stream.of("02", "21", "22", "23", "24", "25", "26", "81", "82", "83").collect(Collectors.toList()));
        put("2327", Stream.of("01", "21", "22").collect(Collectors.toList()));

        //上海市
        put("3101", Stream.of("01", "04", "05", "06", "07", "09", "10", "12", "13", "14", "15", "16", "17", "18", "20", "51").collect(Collectors.toList()));

        //江苏省
        put("3201", Stream.of("02", "04", "05", "06", "11", "13", "14", "15", "16", "17", "18").collect(Collectors.toList()));
        put("3202", Stream.of("05", "06", "11", "13", "14", "81", "82").collect(Collectors.toList()));
        put("3203", Stream.of("02", "03", "05", "11", "12", "21", "22", "24", "81", "82").collect(Collectors.toList()));
        put("3204", Stream.of("02", "04", "11", "12", "13", "81").collect(Collectors.toList()));
        put("3205", Stream.of("05", "06", "07", "08", "09", "81", "82", "83", "85").collect(Collectors.toList()));
        put("3206", Stream.of("12", "13", "14", "23", "81", "82", "85").collect(Collectors.toList()));
        put("3207", Stream.of("03", "06", "07", "22", "23", "24").collect(Collectors.toList()));
        put("3208", Stream.of("03", "04", "12", "13", "26", "30", "31").collect(Collectors.toList()));
        put("3209", Stream.of("02", "03", "04", "21", "22", "23", "24", "25", "81").collect(Collectors.toList()));
        put("3210", Stream.of("02", "03", "12", "23", "81", "84").collect(Collectors.toList()));
        put("3211", Stream.of("02", "11", "12", "81", "82", "83").collect(Collectors.toList()));
        put("3212", Stream.of("02", "03", "04", "81", "82", "83").collect(Collectors.toList()));
        put("3213", Stream.of("02", "11", "22", "23", "24").collect(Collectors.toList()));

        //浙江省
        put("3301", Stream.of("02", "05", "06", "08", "09", "10", "11", "12", "13", "14", "22", "27", "82").collect(Collectors.toList()));
        put("3302", Stream.of("03", "05", "06", "11", "12", "13", "25", "26", "81", "82").collect(Collectors.toList()));
        put("3303", Stream.of("02", "03", "04", "05", "24", "26", "27", "28", "29", "81", "82", "83").collect(Collectors.toList()));
        put("3304", Stream.of("02", "11", "21", "24", "81", "82", "83").collect(Collectors.toList()));
        put("3305", Stream.of("02", "03", "21", "22", "23").collect(Collectors.toList()));
        put("3306", Stream.of("02", "03", "04", "24", "81", "83").collect(Collectors.toList()));
        put("3307", Stream.of("02", "03", "23", "26", "27", "81", "82", "83", "84").collect(Collectors.toList()));
        put("3308", Stream.of("02", "03", "22", "24", "25", "81").collect(Collectors.toList()));
        put("3309", Stream.of("02", "03", "21", "22").collect(Collectors.toList()));
        put("3310", Stream.of("02", "03", "04", "22", "23", "24", "81", "82", "83").collect(Collectors.toList()));
        put("3311", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "81").collect(Collectors.toList()));

        //安徽省
        put("3401", Stream.of("02", "03", "04", "11", "21", "22", "23", "24", "81").collect(Collectors.toList()));
        put("3402", Stream.of("02", "07", "09", "10", "12", "23", "81").collect(Collectors.toList()));
        put("3403", Stream.of("02", "03", "04", "11", "21", "22", "23").collect(Collectors.toList()));
        put("3404", Stream.of("02", "03", "04", "05", "06", "21", "22").collect(Collectors.toList()));
        put("3405", Stream.of("03", "04", "06", "21", "22", "23").collect(Collectors.toList()));
        put("3406", Stream.of("02", "03", "04", "21").collect(Collectors.toList()));
        put("3407", Stream.of("05", "06", "11", "22").collect(Collectors.toList()));
        put("3408", Stream.of("02", "03", "11", "22", "25", "26", "27", "28", "81", "82").collect(Collectors.toList()));
        put("3410", Stream.of("02", "03", "04", "21", "22", "23", "24").collect(Collectors.toList()));
        put("3411", Stream.of("02", "03", "22", "24", "25", "26", "81", "82").collect(Collectors.toList()));
        put("3412", Stream.of("02", "03", "04", "21", "22", "25", "26", "82").collect(Collectors.toList()));
        put("3413", Stream.of("02", "21", "22", "23", "24").collect(Collectors.toList()));
        put("3415", Stream.of("02", "03", "04", "22", "23", "24", "25").collect(Collectors.toList()));
        put("3416", Stream.of("02", "21", "22", "23").collect(Collectors.toList()));
        put("3417", Stream.of("02", "21", "22", "23").collect(Collectors.toList()));
        put("3418", Stream.of("02", "21", "23", "24", "25", "81", "82").collect(Collectors.toList()));

        //福建省
        put("3501", Stream.of("02", "03", "04", "05", "11", "12", "21", "22", "23", "24", "25", "28", "81").collect(Collectors.toList()));
        put("3502", Stream.of("03", "05", "06", "11", "12", "13").collect(Collectors.toList()));
        put("3503", Stream.of("02", "03", "04", "05", "22").collect(Collectors.toList()));
        put("3504", Stream.of("04", "05", "21", "23", "24", "25", "26", "28", "29", "30", "81").collect(Collectors.toList()));
        put("3505", Stream.of("02", "03", "04", "05", "21", "24", "25", "26", "27", "81", "82", "83").collect(Collectors.toList()));
        put("3506", Stream.of("02", "03", "04", "05", "22", "23", "24", "26", "27", "28", "29").collect(Collectors.toList()));
        put("3507", Stream.of("02", "03", "21", "22", "23", "24", "25", "81", "82", "83").collect(Collectors.toList()));
        put("3508", Stream.of("02", "03", "21", "23", "24", "25", "81").collect(Collectors.toList()));
        put("3509", Stream.of("02", "21", "22", "23", "24", "25", "26", "81", "82").collect(Collectors.toList()));

        //江西省
        put("3601", Stream.of("02", "03", "04", "11", "12", "13", "21", "23", "24").collect(Collectors.toList()));
        put("3602", Stream.of("02", "03", "22", "81").collect(Collectors.toList()));
        put("3603", Stream.of("02", "13", "21", "22", "23").collect(Collectors.toList()));
        put("3604", Stream.of("02", "03", "04", "23", "24", "25", "26", "28", "29", "30", "81", "82", "83").collect(Collectors.toList()));
        put("3605", Stream.of("02", "21").collect(Collectors.toList()));
        put("3606", Stream.of("02", "03", "81").collect(Collectors.toList()));
        put("3607", Stream.of("02", "03", "04", "22", "23", "24", "25", "26", "28", "29", "30", "31", "32", "33", "34", "35", "81", "83").collect(Collectors.toList()));
        put("3608", Stream.of("02", "03", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "81").collect(Collectors.toList()));
        put("3609", Stream.of("02", "21", "22", "23", "24", "25", "26", "81", "82", "83").collect(Collectors.toList()));
        put("3610", Stream.of("02", "03", "21", "22", "23", "24", "25", "26", "27", "28", "30").collect(Collectors.toList()));
        put("3611", Stream.of("02", "03", "04", "23", "24", "25", "26", "27", "28", "29", "30", "81").collect(Collectors.toList()));

        //山东省
        put("3701", Stream.of("02", "03", "04", "05", "12", "13", "14", "15", "16", "17", "24", "26").collect(Collectors.toList()));
        put("3702", Stream.of("02", "03", "11", "12", "13", "14", "15", "81", "83", "85").collect(Collectors.toList()));
        put("3703", Stream.of("02", "03", "04", "05", "06", "21", "22", "23").collect(Collectors.toList()));
        put("3704", Stream.of("02", "03", "04", "05", "06", "81").collect(Collectors.toList()));
        put("3705", Stream.of("02", "03", "05", "22", "23").collect(Collectors.toList()));
        put("3706", Stream.of("02", "11", "12", "13", "14", "81", "82", "83", "85", "86", "87").collect(Collectors.toList()));
        put("3707", Stream.of("02", "03", "04", "05", "24", "25", "81", "82", "83", "84", "85", "86").collect(Collectors.toList()));
        put("3708", Stream.of("11", "12", "26", "27", "28", "29", "30", "31", "32", "81", "83").collect(Collectors.toList()));
        put("3709", Stream.of("02", "11", "21", "23", "82", "83").collect(Collectors.toList()));
        put("3710", Stream.of("02", "03", "82", "83").collect(Collectors.toList()));
        put("3711", Stream.of("02", "03", "21", "22").collect(Collectors.toList()));
        put("3713", Stream.of("02", "11", "12", "21", "22", "23", "24", "25", "26", "27", "28", "29").collect(Collectors.toList()));
        put("3714", Stream.of("02", "03", "22", "23", "24", "25", "26", "27", "28", "81", "82").collect(Collectors.toList()));
        put("3715", Stream.of("02", "03", "21", "22", "24", "25", "26", "81").collect(Collectors.toList()));
        put("3716", Stream.of("02", "03", "21", "22", "23", "25", "81").collect(Collectors.toList()));
        put("3717", Stream.of("02", "03", "21", "22", "23", "24", "25", "26", "28").collect(Collectors.toList()));

        //河南省
        put("4101", Stream.of("02", "03", "04", "05", "06", "08", "22", "81", "82", "83", "84", "85").collect(Collectors.toList()));
        put("4102", Stream.of("02", "03", "05", "12", "21", "22", "23", "25").collect(Collectors.toList()));
        put("4103", Stream.of("02", "03", "04", "05", "07", "08", "11", "23", "24", "25", "26", "27", "28", "29").collect(Collectors.toList()));
        put("4104", Stream.of("02", "03", "04", "11", "21", "22", "23", "25", "81", "82").collect(Collectors.toList()));
        put("4105", Stream.of("02", "03", "05", "06", "22", "23", "26", "27", "81").collect(Collectors.toList()));
        put("4106", Stream.of("02", "03", "11", "21", "22").collect(Collectors.toList()));
        put("4107", Stream.of("02", "03", "04", "11", "21", "24", "25", "26", "27", "81", "82", "83").collect(Collectors.toList()));
        put("4108", Stream.of("02", "03", "04", "11", "21", "22", "23", "25", "82", "83").collect(Collectors.toList()));
        put("4109", Stream.of("02", "22", "23", "26", "27", "28").collect(Collectors.toList()));
        put("4110", Stream.of("02", "03", "24", "25", "81", "82").collect(Collectors.toList()));
        put("4111", Stream.of("02", "03", "04", "21", "22").collect(Collectors.toList()));
        put("4112", Stream.of("02", "03", "21", "24", "81", "82").collect(Collectors.toList()));
        put("4113", Stream.of("02", "03", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "81").collect(Collectors.toList()));
        put("4114", Stream.of("02", "03", "21", "22", "23", "24", "25", "26", "81").collect(Collectors.toList()));
        put("4115", Stream.of("02", "03", "21", "22", "23", "24", "25", "26", "27", "28").collect(Collectors.toList()));
        put("4116", Stream.of("02", "03", "21", "22", "23", "24", "25", "27", "28", "81").collect(Collectors.toList()));
        put("4117", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "28", "29").collect(Collectors.toList()));
        put("4190", Stream.of("01").collect(Collectors.toList())); //济源市4190

        //湖北省
        put("4201", Stream.of("02", "03", "04", "05", "06", "07", "11", "12", "13", "14", "15", "16", "17").collect(Collectors.toList()));
        put("4202", Stream.of("02", "03", "04", "05", "22", "81").collect(Collectors.toList()));
        put("4203", Stream.of("02", "03", "04", "22", "23", "24", "25", "81").collect(Collectors.toList()));
        put("4205", Stream.of("02", "03", "04", "05", "06", "25", "26", "27", "28", "29", "81", "82", "83").collect(Collectors.toList()));
        put("4206", Stream.of("02", "06", "07", "24", "25", "26", "82", "83", "84").collect(Collectors.toList()));
        put("4207", Stream.of("02", "03", "04").collect(Collectors.toList()));
        put("4208", Stream.of("02", "04", "22", "81", "82").collect(Collectors.toList()));
        put("4209", Stream.of("02", "21", "22", "23", "81", "82", "84").collect(Collectors.toList()));
        put("4210", Stream.of("02", "03", "22", "24", "81", "83", "87", "88").collect(Collectors.toList()));
        put("4211", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "81", "82").collect(Collectors.toList()));
        put("4212", Stream.of("02", "21", "22", "23", "24", "81").collect(Collectors.toList()));
        put("4213", Stream.of("03", "21", "81").collect(Collectors.toList()));
        put("4228", Stream.of("01", "02", "22", "23", "25", "26", "27", "28").collect(Collectors.toList()));
        put("4229", Stream.of("04", "05", "06", "21").collect(Collectors.toList())); //恩施土家族苗族自治州4228 下属仙桃市-->神农架林区市4290

        //湖南省
        put("4301", Stream.of("02", "03", "04", "05", "11", "12", "21", "81", "82").collect(Collectors.toList()));
        put("4302", Stream.of("02", "03", "04", "11", "12", "23", "24", "25", "81").collect(Collectors.toList()));
        put("4303", Stream.of("02", "04", "21", "81", "82").collect(Collectors.toList()));
        put("4304", Stream.of("05", "06", "07", "08", "12", "21", "22", "23", "24", "26", "81", "82").collect(Collectors.toList()));
        put("4305", Stream.of("02", "03", "11", "22", "23", "24", "25", "27", "28", "29", "81", "82").collect(Collectors.toList()));
        put("4306", Stream.of("02", "03", "11", "21", "23", "24", "26", "81", "82").collect(Collectors.toList()));
        put("4307", Stream.of("02", "03", "21", "22", "23", "24", "25", "26", "81").collect(Collectors.toList()));
        put("4308", Stream.of("02", "11", "21", "22").collect(Collectors.toList()));
        put("4309", Stream.of("02", "03", "21", "22", "23", "81").collect(Collectors.toList()));
        put("4310", Stream.of("02", "03", "21", "22", "23", "24", "25", "26", "27", "28", "81").collect(Collectors.toList()));
        put("4311", Stream.of("02", "03", "22", "23", "24", "25", "26", "27", "28", "29", "81").collect(Collectors.toList()));
        put("4312", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "81").collect(Collectors.toList()));
        put("4313", Stream.of("02", "21", "22", "81", "82").collect(Collectors.toList()));
        put("4331", Stream.of("01", "22", "23", "24", "25", "26", "27", "30").collect(Collectors.toList()));

        //广东省
        put("4401", Stream.of("03", "04", "05", "06", "11", "12", "13", "14", "15", "17", "18").collect(Collectors.toList()));
        put("4402", Stream.of("03", "04", "05", "22", "24", "29", "32", "33", "81", "82").collect(Collectors.toList()));
        put("4403", Stream.of("03", "04", "05", "06", "07", "08", "09", "10", "11").collect(Collectors.toList()));
        put("4404", Stream.of("02", "03", "04").collect(Collectors.toList()));
        put("4405", Stream.of("07", "11", "12", "13", "14", "15", "23").collect(Collectors.toList()));
        put("4406", Stream.of("04", "05", "06", "07", "08").collect(Collectors.toList()));
        put("4407", Stream.of("03", "04", "05", "81", "83", "84", "85").collect(Collectors.toList()));
        put("4408", Stream.of("02", "03", "04", "11", "23", "25", "81", "82", "83").collect(Collectors.toList()));
        put("4409", Stream.of("02", "04", "81", "82", "83").collect(Collectors.toList()));
        put("4412", Stream.of("02", "03", "04", "23", "24", "25", "26", "84").collect(Collectors.toList()));
        put("4413", Stream.of("02", "03", "22", "23", "24").collect(Collectors.toList()));
        put("4414", Stream.of("02", "03", "22", "23", "24", "26", "27", "81").collect(Collectors.toList()));
        put("4415", Stream.of("02", "21", "23", "81").collect(Collectors.toList()));
        put("4416", Stream.of("02", "21", "22", "23", "24", "25").collect(Collectors.toList()));
        put("4417", Stream.of("02", "04", "21", "81").collect(Collectors.toList()));
        put("4418", Stream.of("02", "03", "21", "23", "25", "26", "81", "82").collect(Collectors.toList()));
        put("4451", Stream.of("02", "03", "22").collect(Collectors.toList()));
        put("4452", Stream.of("02", "03", "22", "24", "81").collect(Collectors.toList()));
        put("4453", Stream.of("02", "03", "21", "22", "81").collect(Collectors.toList()));

        //广西壮族自治区
        put("4501", Stream.of("02", "03", "05", "07", "08", "09", "10", "23", "24", "25", "26", "81").collect(Collectors.toList()));
        put("4502", Stream.of("02", "03", "04", "05", "06", "22", "23", "24", "25", "26").collect(Collectors.toList()));
        put("4503", Stream.of("02", "03", "04", "05", "11", "12", "21", "23", "24", "25", "26", "27", "28", "29", "30", "32", "81").collect(Collectors.toList()));
        put("4504", Stream.of("03", "05", "06", "21", "22", "23", "81").collect(Collectors.toList()));
        put("4505", Stream.of("02", "03", "12", "21").collect(Collectors.toList()));
        put("4506", Stream.of("02", "03", "21", "81").collect(Collectors.toList()));
        put("4507", Stream.of("02", "03", "21", "22").collect(Collectors.toList()));
        put("4508", Stream.of("02", "03", "04", "21", "81").collect(Collectors.toList()));
        put("4509", Stream.of("02", "03", "21", "22", "23", "24", "81").collect(Collectors.toList()));
        put("4510", Stream.of("02", "03", "22", "24", "26", "27", "28", "29", "30", "31", "81", "82").collect(Collectors.toList()));
        put("4511", Stream.of("02", "03", "21", "22", "23").collect(Collectors.toList()));
        put("4512", Stream.of("02", "03", "21", "22", "23", "24", "25", "26", "27", "28", "29").collect(Collectors.toList()));
        put("4513", Stream.of("02", "21", "22", "23", "24", "81").collect(Collectors.toList()));
        put("4514", Stream.of("02", "21", "22", "23", "24", "25", "81").collect(Collectors.toList()));

        //海南省
        put("4601", Stream.of("05", "06", "07", "08").collect(Collectors.toList()));
        put("4602", Stream.of("02", "03", "04", "05").collect(Collectors.toList()));
        put("4603", Stream.of("00").collect(Collectors.toList())); //三沙市西沙区 TODO//为空暂填00
        put("4603", Stream.of("00").collect(Collectors.toList())); //三沙市南沙区 TODO//为空暂填00
        put("4604", Stream.of("00").collect(Collectors.toList())); //注：儋州市4604 下属全为4690
        put("4690", Stream.of("01", "02", "05", "06", "07", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30").collect(Collectors.toList()));

        //重庆市
        put("5001", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "51", "52", "53", "54", "55", "56").collect(Collectors.toList()));
        put("5002", Stream.of("29", "30", "31", "33", "35", "36", "37", "38", "40", "41", "42", "43").collect(Collectors.toList())); //城口县 --> 彭水苗族土家族自治县 5002

        //四川省
        put("5101", Stream.of("04", "05", "06", "07", "08", "12", "13", "14", "15", "16", "17", "18", "21", "29", "31", "81", "82", "83", "84", "85").collect(Collectors.toList()));
        put("5103", Stream.of("02", "03", "04", "11", "21", "22").collect(Collectors.toList()));
        put("5104", Stream.of("02", "03", "11", "21", "22").collect(Collectors.toList()));
        put("5105", Stream.of("02", "03", "04", "21", "22", "24", "25").collect(Collectors.toList()));
        put("5106", Stream.of("03", "04", "23", "81", "82", "83").collect(Collectors.toList()));
        put("5107", Stream.of("03", "04", "05", "22", "23", "25", "26", "27", "81").collect(Collectors.toList()));
        put("5108", Stream.of("02", "11", "12", "21", "22", "23", "24").collect(Collectors.toList()));
        put("5109", Stream.of("03", "04", "21", "23", "81").collect(Collectors.toList()));
        put("5110", Stream.of("02", "11", "24", "25", "83").collect(Collectors.toList()));
        put("5111", Stream.of("02", "11", "12", "13", "23", "24", "26", "29", "32", "33", "81").collect(Collectors.toList()));
        put("5113", Stream.of("02", "03", "04", "21", "22", "23", "24", "25", "81").collect(Collectors.toList()));
        put("5114", Stream.of("02", "03", "21", "23", "24", "25").collect(Collectors.toList()));
        put("5115", Stream.of("02", "03", "04", "23", "24", "25", "26", "27", "28", "29").collect(Collectors.toList()));
        put("5116", Stream.of("02", "03", "21", "22", "23", "81").collect(Collectors.toList()));
        put("5117", Stream.of("02", "03", "22", "23", "24", "25", "81").collect(Collectors.toList()));
        put("5118", Stream.of("02", "03", "22", "23", "24", "25", "26", "27").collect(Collectors.toList()));
        put("5119", Stream.of("02", "03", "21", "22", "23").collect(Collectors.toList()));
        put("5120", Stream.of("02", "21", "22").collect(Collectors.toList()));
        put("5132", Stream.of("01", "21", "22", "23", "24", "25", "26", "27", "28", "30", "31", "32", "33").collect(Collectors.toList()));
        put("5133", Stream.of("01", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38").collect(Collectors.toList()));
        put("5134", Stream.of("01", "02", "22", "23", "24", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37").collect(Collectors.toList()));

        //贵州省
        put("5201", Stream.of("02", "03", "11", "12", "13", "15", "21", "22", "23", "81").collect(Collectors.toList()));
        put("5202", Stream.of("01", "03", "04", "81").collect(Collectors.toList()));
        put("5203", Stream.of("02", "03", "04", "22", "23", "24", "25", "26", "27", "28", "29", "30", "81", "82").collect(Collectors.toList()));
        put("5204", Stream.of("02", "03", "22", "23", "24", "25").collect(Collectors.toList()));
        put("5205", Stream.of("02", "21", "23", "24", "25", "26", "27", "81").collect(Collectors.toList()));
        put("5206", Stream.of("02", "03", "21", "22", "23", "24", "25", "26", "27", "28").collect(Collectors.toList()));
        put("5223", Stream.of("01", "02", "23", "24", "25", "26", "27", "28").collect(Collectors.toList()));
        put("5226", Stream.of("01", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36").collect(Collectors.toList()));
        put("5227", Stream.of("01", "02", "22", "23", "25", "26", "27", "28", "29", "30", "31", "32").collect(Collectors.toList()));

        //云南省
        put("5301", Stream.of("02", "03", "11", "12", "13", "14", "15", "24", "25", "26", "27", "28", "29", "81").collect(Collectors.toList()));
        put("5303", Stream.of("02", "03", "04", "22", "23", "24", "25", "26", "81").collect(Collectors.toList()));
        put("5304", Stream.of("02", "03", "23", "24", "25", "26", "27", "28", "81").collect(Collectors.toList()));
        put("5305", Stream.of("02", "21", "23", "24", "81").collect(Collectors.toList()));
        put("5306", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "28", "29", "81").collect(Collectors.toList()));
        put("5307", Stream.of("02", "21", "22", "23", "24").collect(Collectors.toList()));
        put("5308", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "28", "29").collect(Collectors.toList()));
        put("5309", Stream.of("02", "21", "22", "23", "24", "25", "26", "27").collect(Collectors.toList()));
        put("5323", Stream.of("01", "02", "22", "23", "24", "25", "26", "27", "28", "29").collect(Collectors.toList()));
        put("5325", Stream.of("01", "02", "03", "04", "23", "24", "25", "27", "28", "29", "30", "31", "32").collect(Collectors.toList()));
        put("5326", Stream.of("01", "22", "23", "24", "25", "26", "27", "28").collect(Collectors.toList()));
        put("5328", Stream.of("01", "22", "23").collect(Collectors.toList()));
        put("5329", Stream.of("01", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32").collect(Collectors.toList()));
        put("5331", Stream.of("02", "03", "22", "23", "24").collect(Collectors.toList()));
        put("5333", Stream.of("01", "23", "24", "25").collect(Collectors.toList()));
        put("5334", Stream.of("01", "22", "23").collect(Collectors.toList()));

        //西藏自治区
        put("5401", Stream.of("02", "03", "04", "21", "22", "23", "24", "27").collect(Collectors.toList()));
        put("5402", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37").collect(Collectors.toList()));
        put("5403", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30").collect(Collectors.toList()));
        put("5404", Stream.of("02", "21", "22", "23", "24", "25", "26").collect(Collectors.toList()));
        put("5405", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31").collect(Collectors.toList()));
        put("5406", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30").collect(Collectors.toList()));
        put("5425", Stream.of("21", "22", "23", "24", "25", "26", "27").collect(Collectors.toList()));

        //陕西省
        put("6101", Stream.of("02", "03", "04", "11", "12", "13", "14", "15", "16", "17", "18", "22", "24").collect(Collectors.toList()));
        put("6102", Stream.of("02", "03", "04", "22").collect(Collectors.toList()));
        put("6103", Stream.of("02", "03", "04", "05", "23", "24", "26", "27", "28", "29", "30", "31").collect(Collectors.toList()));
        put("6104", Stream.of("02", "03", "04", "22", "23", "24", "25", "26", "28", "29", "30", "31", "81", "82").collect(Collectors.toList()));
        put("6105", Stream.of("02", "03", "22", "23", "24", "25", "26", "27", "28", "81", "82").collect(Collectors.toList()));
        put("6106", Stream.of("02", "03", "21", "22", "25", "26", "27", "28", "29", "30", "31", "32", "81").collect(Collectors.toList()));
        put("6107", Stream.of("02", "03", "22", "23", "24", "25", "26", "27", "28", "29", "30").collect(Collectors.toList()));
        put("6108", Stream.of("02", "03", "22", "24", "25", "26", "27", "28", "29", "30", "31", "81").collect(Collectors.toList()));
        put("6109", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "29", "81").collect(Collectors.toList()));
        put("6110", Stream.of("02", "21", "22", "23", "24", "25", "26").collect(Collectors.toList()));

        //甘肃省
        put("6201", Stream.of("02", "03", "04", "05", "11", "21", "22", "23").collect(Collectors.toList()));
        put("6203", Stream.of("02", "21").collect(Collectors.toList()));
        put("6204", Stream.of("02", "03", "21", "22", "23").collect(Collectors.toList()));
        put("6205", Stream.of("02", "03", "21", "22", "23", "24", "25").collect(Collectors.toList()));
        put("6206", Stream.of("02", "21", "22", "23").collect(Collectors.toList()));
        put("6207", Stream.of("02", "21", "22", "23", "24", "25").collect(Collectors.toList()));
        put("6208", Stream.of("02", "21", "22", "23", "25", "26", "81").collect(Collectors.toList()));
        put("6209", Stream.of("02", "21", "22", "23", "24", "81", "82").collect(Collectors.toList()));
        put("6210", Stream.of("02", "21", "22", "23", "24", "25", "26", "27").collect(Collectors.toList()));
        put("6211", Stream.of("02", "21", "22", "23", "24", "25", "26").collect(Collectors.toList()));
        put("6212", Stream.of("02", "21", "22", "23", "24", "25", "26", "27", "28").collect(Collectors.toList()));
        put("6229", Stream.of("01", "21", "22", "23", "24", "25", "26", "27").collect(Collectors.toList()));
        put("6230", Stream.of("01", "21", "22", "23", "24", "25", "26", "27").collect(Collectors.toList()));

        //青海省
        put("6301", Stream.of("02", "03", "04", "05", "06", "21", "23").collect(Collectors.toList()));
        put("6302", Stream.of("02", "03", "22", "23", "24", "25").collect(Collectors.toList()));
        put("6322", Stream.of("21", "22", "23", "24").collect(Collectors.toList()));
        put("6323", Stream.of("01", "22", "23", "24").collect(Collectors.toList()));
        put("6325", Stream.of("21", "22", "23", "24", "25").collect(Collectors.toList()));
        put("6326", Stream.of("21", "22", "23", "24", "25", "26").collect(Collectors.toList()));
        put("6327", Stream.of("01", "22", "23", "24", "25", "26").collect(Collectors.toList()));
        put("6328", Stream.of("01", "02", "03", "21", "22", "23").collect(Collectors.toList()));

        //宁夏回族自治区
        put("6401", Stream.of("04", "05", "06", "21", "22", "81").collect(Collectors.toList()));
        put("6402", Stream.of("02", "05", "21").collect(Collectors.toList()));
        put("6403", Stream.of("02", "03", "23", "24", "81").collect(Collectors.toList()));
        put("6404", Stream.of("02", "22", "23", "24", "25").collect(Collectors.toList()));
        put("6405", Stream.of("02", "21", "22").collect(Collectors.toList()));

        //新疆维吾尔自治区
        put("6501", Stream.of("02", "03", "04", "05", "06", "07", "09", "21").collect(Collectors.toList()));
        put("6502", Stream.of("02", "03", "04", "05").collect(Collectors.toList()));
        put("6504", Stream.of("02", "21", "22").collect(Collectors.toList()));
        put("6505", Stream.of("02", "21", "22").collect(Collectors.toList()));
        put("6523", Stream.of("01", "02", "23", "24", "25", "27", "28").collect(Collectors.toList()));
        put("6527", Stream.of("01", "02", "22", "23").collect(Collectors.toList()));
        put("6528", Stream.of("01", "22", "23", "24", "25", "26", "27", "28", "29").collect(Collectors.toList()));
        put("6529", Stream.of("01", "02", "22", "24", "25", "26", "27", "28", "29").collect(Collectors.toList()));
        put("6530", Stream.of("01", "22", "23", "24").collect(Collectors.toList()));
        put("6531", Stream.of("01", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31").collect(Collectors.toList()));
        put("6532", Stream.of("01", "21", "22", "23", "24", "25", "26", "27").collect(Collectors.toList()));
        put("6540", Stream.of("02", "03", "04", "21", "22", "23", "24", "25", "26", "27", "28").collect(Collectors.toList()));
        put("6542", Stream.of("01", "02", "03", "21", "24", "25", "26").collect(Collectors.toList()));
        put("6543", Stream.of("01", "21", "22", "23", "24", "25", "26").collect(Collectors.toList()));
        put("6590", Stream.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11").collect(Collectors.toList()));

        //台湾 710000
        put("7100", Stream.of("00").collect(Collectors.toList()));

        //香港特别行政区 810000
        put("8100", Stream.of("00").collect(Collectors.toList()));

        //澳门特别行政区 820000
        put("8200", Stream.of("00").collect(Collectors.toList()));
        put("8300", Stream.of("00").collect(Collectors.toList()));
    }};

    /**
     * 加权因子
     */
    private final static int[] WEIGHT_FACTOR = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    /**
     * 生成身份证代码
     * 两种生成模式，
     * -- 1.指定
     * -- 2.随机
     *
     * @return
     */
    public String generate() {
        Random random = new Random(System.currentTimeMillis());
        // 1.随机出大区 1 (1-9)
        String regionCode = (random.nextInt(REGION_CODE_MAP.size()) + 1) + "";
        if ("9".equals(regionCode)) {
            return "暂不支持";
        }

        // 2.随机出省 1
        List<String> provinceCodeList = REGION_CODE_MAP.get(regionCode);
        int provinceIndex = random.nextInt(provinceCodeList.size());
        String provinceCode = provinceCodeList.get(provinceIndex);

        // 3.随机出市 2
        List<String> cityList = CITY_CODE_MAP.get(String.format("%s%s", regionCode, provinceCode));
        int cityIndex = random.nextInt(cityList.size());
        String cityCode = cityList.get(cityIndex);

        // 4.随机出区 2
        List<String> countyCodeList = COUNTY_CODE_MAP.get(String.format("%s%s%s", regionCode, provinceCode, cityCode));
        int countyIndex = random.nextInt(countyCodeList.size());
        String countyCode = countyCodeList.get(countyIndex);

        // 5.随机出年份 4
        String year = (random.nextInt(LocalDate.now().getYear() - 2000) + 2000) + "";

        // 6.随机出月份 2
        int month = random.nextInt(11) + 1;
        String monthCode;
        if (month >= 10) {
            monthCode = month + "";
        } else {
            monthCode = "0" + month;
        }

        // 7.随机出日 2
        int days = days(Integer.parseInt(year), month);
        int day = random.nextInt(days) + 1;
        String dayCode;
        if (day >= 10) {
            dayCode = day + "";
        } else {
            dayCode = "0" + day;
        }

        // 8.随机出顺序码 2
        // 9.随机出性别 1
        String randomCode = random.nextInt(998) + 1 + "";
        // 10.计算校验码 1
        String idCardNum = String.format("%s%s%s%s%s%s%s%s", regionCode, provinceCode, cityCode, countyCode, year, monthCode, dayCode, randomCode);
        int num = 0;
        for (int i = 0; i < idCardNum.length(); i++) {
            char c = idCardNum.charAt(i);
            int numericValue = Character.getNumericValue(c);
            num += numericValue * WEIGHT_FACTOR[i];
        }
        String checkCode = checkCode(num % 11);
        return String.format("%s%s", idCardNum, checkCode);
    }

    /**
     * 返回校验码
     *
     * @param num
     * @return
     */
    private static String checkCode(int num) {
        switch (num) {
            case 0:
                return "1";
            case 1:
                return "0";
            case 2:
                return "X";
            case 3:
                return "9";
            case 4:
                return "8";
            case 5:
                return "7";
            case 6:
                return "6";
            case 7:
                return "5";
            case 8:
                return "4";
            case 9:
                return "3";
            case 10:
                return "2";
            default:
                throw new IllegalArgumentException("传入参数错误，不存在该值对应的数据。num=" + num);
        }
    }

    private int days(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            if (month == 2) {
                return 29;
            }
        } else {
            if (month == 2) {
                return 28;
            }
        }
        throw new IllegalArgumentException("错误的年月");
    }
}
