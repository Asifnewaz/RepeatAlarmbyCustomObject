package com.asifnewaz.alarmwithcustomobjectdb;

/**
 * Created by asifn on 9/1/2017.
 */

public class AlarmLog {
    int id;
    String text;
    String time;
    public AlarmLog(){   }

    public AlarmLog(String text, String time){
        this.text = text;
        this.time = time;
    }
    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getText(){
        return this.text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getTime(){
        return this.time;
    }

    public void setTime(String time){
        this.time = time;
    }
}