package com.icia.board.utill;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtillClass {
    //날짜 데이터 변경용메 메서드(년월일시분초)
    public static String dateTimeFormat(LocalDateTime dateTime){
        if(dateTime==null)
            return null;
        else
            return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
