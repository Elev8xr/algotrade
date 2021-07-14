package com.example.restservice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.Date;
import java.util.Set;
/*
a template for the Keyword Object

 */

public class Keyword {
    Set<String>websites;
    String word ;
    int totalMentions;
    double avgPerDay;
    int numOfPosts;
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date startDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date endDate;

    public Keyword(Set<String>websites,String word ,int totalMentions ,double avgPerDay ,int numOfPosts , Date startDate , Date endDate){
        this.word = word;
        this.totalMentions = totalMentions;
        this.avgPerDay = avgPerDay;
        this.numOfPosts = numOfPosts ;
        this.startDate = startDate;
        this.endDate = endDate;
        this.websites = websites;

    }
    public Keyword(){

    }
    public String getWord(){
        return word;
    }
    public double getAvgPerDay(){
        return avgPerDay;
    }
    public int getTotalMentions(){
        return totalMentions;
    }
    public Date getStartDate(){
        return startDate;
    }
    public Date getEndDate(){
        return endDate;
    }
    public Set<String> getWebsites(){
        return websites;
    }


    /*@Override
    public String toString() {
        return String.format("{keyword:%s,totalMentions:%s,avgPerDay:%s,numOfArticles:%s,startDate:%s,endDate:%s}"
        ,word,totalMentions,avgPerDay,numOfPosts,startDate,endDate);
    }*/
}
