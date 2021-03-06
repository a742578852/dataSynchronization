package com.llmc.dataSynchronization.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

    private static final String EMPTY = "";

    public StringUtils() {
    }

    public static boolean isEmptyString(String str) {
        return str == null || "".equals(str.trim()) || str.length() <= 0 || "NULL".equals(str.toUpperCase());
    }

    public static String join(Object array, String separator, boolean asString) {
        if (array == null) {
            return "";
        }

        if (array.getClass().isArray()) {
            int arraylength = Array.getLength(array);
            return join(array, separator, asString, 0, arraylength - 1);
        }

        throw new IllegalArgumentException("StringUtils.join():The param [Object array] must be a array!");
    }


    public static String join(Object array, String separator, boolean asString, int startIndex, int endIndex) {
        if (array == null) {
            return "";
        }

        if (array.getClass().isArray()) {
            StringBuilder buffer = new StringBuilder();

            separator = (separator == null) ? "" : separator;

            for (int i = startIndex; i <= endIndex; ++i) {
                Object dataEle = Array.get(array, i);

                if (dataEle != null) {
                    dataEle = (asString) ? "" + dataEle + "" : dataEle.toString();
                    buffer.append(dataEle);
                }

                if (i < endIndex)
                    buffer.append(separator);

            }

            return buffer.toString();
        }

        throw new IllegalArgumentException("StringUtils.join():The param [Object array] must be a array!");
    }


    /**
     * ??????????????????????????????List<Integer>
     */
    public static List<Integer> stringtoList(String temp) {
        if (null == temp || temp.trim().length() == 0) {
            return null;
        }
        return Arrays.asList(temp.split(","))
                .stream().map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
    }

    /**
     * ???????????????
     *
     * @param params
     * @return
     */
    public static String toLowerCase(String params) {
        if (params != null) {
            return params.toLowerCase();
        } else {
            return "";
        }
    }

    /**
     * ???string?????????int??????
     *
     * @param strs
     * @return
     */
    public static int[] stringToInt(String strs) {
        if (null == strs || strs.trim().length() == 0) {
            return null;
        }
        String[] str = strs.split(",");
        int[] ints = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            ints[i] = Integer.parseInt(str[i]);
        }
        return ints;
    }

    /**
     * ???string?????????string??????
     *
     * @param strs
     * @return
     */
    public static String[] stringToString(String strs) {
        if (null == strs || strs.trim().length() == 0) {
            return null;
        }
        String[] str = strs.split(",");
        String[] str1 = new String[str.length];
        for (int i = 0; i < str.length; i++) {
            str1[i] = str[i];
        }
        return str1;
    }

    /**
     * ???string?????????list??????
     *
     * @param strs
     * @return
     */
    public static List<Long> stringToList(String strs) {
        if (null == strs || strs.trim().length() == 0) {
            return null;
        }
        return Arrays.stream(strs.split(",")).map(a -> Long.parseLong(a)).collect(Collectors.toList());
    }


    /**
     * Object???BigDecimal??????-??????-2018???5???14???09:56:26
     *
     * @param value ?????????object??????
     * @return ?????????BigDecimal????????????
     */
    public static BigDecimal getBigDecimal(Object value) {
        BigDecimal ret = null;
        if (value != null) {
            if (value instanceof BigDecimal) {
                ret = (BigDecimal) value;
            } else if (value instanceof String) {
                ret = new BigDecimal((String) value);
            } else if (value instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) value);
            } else if (value instanceof Number) {
                ret = new BigDecimal(((Number) value).doubleValue());
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
            }
        }
        return ret;
    }

    /**
     * string??????????????? list<Long>
     *
     * @param strs
     * @return
     */
    public static List<Long> toLongList(String[] strs) {
        if (strs.length < 1) {
            return null;
        }
        return Arrays.stream(strs).map(a -> Long.parseLong(a)).collect(Collectors.toList());
    }

    /*public static String getNoBySub(String nullReturnValue, String no, int length, String chars,String prex) {
        if (StringUtils.isEmptyString(no)) {
            return nullReturnValue;
        }
        no = no.substring(no.length()-length);
        int nos = Integer.parseInt(no) + 1;
        String strs = "";
        for (int i = 0; i < length; i++) {
            strs += chars;
        }
        String returnValue = strs + nos;
        return prex+returnValue.substring(returnValue.length() - length);
    }*/

    public static String getNoByDecimalFormat(String nullReturnValue, String no, int length, String chars, String prex) {
        if (StringUtils.isEmptyString(no)) {
            return nullReturnValue;
        }
        no = no.substring(no.length() - length);
        int nos = Integer.parseInt(no) + 1;
        String strs = "";
        for (int i = 0; i < length; i++) {
            strs += chars;
        }
        DecimalFormat df3 = new DecimalFormat(strs);
        return prex + df3.format(nos);
    }

    /**
     * ???????????????
     *
     * @param obj
     * @return
     */
    public static byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    /**
     * ??????uuid
     *
     * @return
     */
    public static String getUuid() {
        String id = null;
        UUID uuid = UUID.randomUUID();
        id = uuid.toString().replace("-", "");

        return id;
    }

    /**
     * ???????????????
     *
     * @param str
     * @return
     */
    public static Boolean isEmpity(String str) {
        if (str == null || str.trim().equals("")) {
            return true;
        } else {
            return false;
        }

    }


}
