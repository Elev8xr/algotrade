package com.example.restservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.Date;
import java.util.Set;
/*
a template for the Keyword Object

 */

public class Keyword {

    String word ;
    int totalMentions;
    double avgPerDay;
    int numOfPosts;
    Date startDate;
    Date endDate;

    public Keyword(String word ,int totalMentions ,double avgPerDay ,int numOfPosts , Date startDate , Date endDate){
        this.word = word;
        this.totalMentions = totalMentions;
        this.avgPerDay = avgPerDay;
        this.numOfPosts = numOfPosts ;
        this.startDate = startDate;
        this.endDate = endDate;

    }

   @Override
    public String toString() {
        return String.format("{keyword:%s,totalMentions:%s,avgPerDay:%s,numOfArticles:%s,startDate:%s,endDate:%s}"
        ,word,totalMentions,avgPerDay,numOfPosts,startDate,endDate);
    }
}
