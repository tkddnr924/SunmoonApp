package com.example.sunmoonapp;

public class Message {
    String nickname, msg, date, time;

    public Message () {}

    public Message (String n, String m, String d, String t) {
        nickname = n;
        msg = m;
        date = d;
        time = t;
    }

    public String getNickname () {return nickname;}
    public String getMsg () {return msg;}
    public String getDate () {return date;}
    public String getTime () {return time;}
}
