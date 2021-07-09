package com.example.restservice;

import java.util.Date;
/*
a template for the article object
 */

public class Article {
    String website ;
    String field ;
    String title;
    String description ;
    Date date;
    String authorName;

    public Article(String website ,String field ,String title,String description ,Date date , String authorName){
        if(website == null)
            website = "Unknown";
        if(authorName == null)
            authorName = "Unknown";

        this.website = website;
        this.field = field;
        this.title = title;
        this.description =description;
        this.date = date;
        this.authorName = authorName;


    }


}
