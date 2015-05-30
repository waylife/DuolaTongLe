package com.sogou.contest.tongle.utils;

import java.text.DecimalFormat;

/**
 * Created by rxread on 5/31/15.
 */
public class FormatUtil {
    public static String formatDistance(int distance){
        DecimalFormat fnum   =   new   DecimalFormat("##KM");
        return fnum.format(distance/1000);
    }

}
