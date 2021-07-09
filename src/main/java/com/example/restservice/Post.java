package com.example.restservice;

import java.util.Date;
import java.util.List;
/*
a template for the Post  object
 */

public class Post {
    String username ;
    String decription;
    List<String>hashtags ;
    int likes;
    int retweets;
    int replays;
    Date date;

    Post(){

    }

    public Post(String username ,String decription ,List<String>hashtags , int likes ,int retweets ,int replays , Date date){
        this.username = username;
        this.decription = decription;
        this.hashtags = hashtags;
        this.likes = likes;
        this.retweets = retweets;
        this.replays = replays;
        this.date = date;
    }
    public Date getDate(){
        return date;
    }


}
