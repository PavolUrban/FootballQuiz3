package com.sample.multiplechoicequiz;

/**
 * Created by pavol on 15. 12. 2017.
 */

public class TimeHelper {

    public static String getTimeFromSeconds(Long totalSecs) {
        Long  minutes = (totalSecs % 3600) / 60;
        Long seconds = totalSecs % 60;

       return  String.format("%02d:%02d",  minutes, seconds);
    }
}
