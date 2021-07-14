package com.example.restservice;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.example.restservice.Keyword;

/*
the crawler manager is a singleton class that has all the method we need
 */
public class CrawlerManager {
 private static CrawlerManager crawlerManager =null;
 public static List<Article>allArticles = new ArrayList<>();
 public static Set<String>allCSVFiles = new HashSet<>();

 private CrawlerManager (){

 }
 //Singleton
 public static  CrawlerManager getInstance(){
     if(crawlerManager == null){
         crawlerManager = new CrawlerManager();
     }

     return  crawlerManager;
 }

 public void LoadUpTheFilesNames(){
        //this set should loadup the data(the csv files names ) form a text file or a csv file
        //template
        allCSVFiles.add("BusinessNews21.csv");
        allCSVFiles.add("MoneyWeek1.csv");

    }



    public void LoadUpDataFromArticlesFile() throws ParseException, IOException, CsvValidationException {
        allArticles.clear();
        for (String path:allCSVFiles) {
            MyCSVReader reader = new MyCSVReader(path);
            String[]Line = reader.ReadLine();
            Date date =new Date() ;
            while (Line != null){
                Line = reader.ReadLine();
                if(Line!=null){
                    if (path == "BusinessNews21.csv") // template need to change
                        date = MyDate.ConvertCNBCStringToDate(Line[3]);
                    else
                        date = MyDate.ConvertMoneyWeekStringToDate(Line[3]);

                    Article article  = new Article(Line[0] ,Line[1] ,Line[2] ,Line[5] ,date,Line[4]);

                    allArticles.add(article);

                }
            }
        }

    }


 void sortArticlesByDate(){
     Collections.sort(allArticles, new Comparator<Article>() {
         @Override
         public int compare(Article o1, Article o2) {
             return  o1.date.compareTo(o2.date);
         }
     });
 }




 List<Article> getAllArticlesBetweenTwoDates(String startDate , String endDate) throws ParseException {

    Date date1 = MyDate.ConvertStringToDate(startDate);
    Date date2 = MyDate.ConvertStringToDate(endDate);
    List <Article> articles = new ArrayList<>();

     for (Article article : allArticles) {
         if((article.date.after(date1)&&article.date.before(date2))
                 || article.date.equals(date1) || article.date.equals(date2)){
             articles.add(article);
         }
     }
     return  articles;
 }

 void printAllAricles()
 {
     for (Article article :allArticles) {
         System.out.println(article.date);
     }
 }
//find the total mentions of certain keyword between to dates
Keyword findKeyword(String keyword ,String startDate ,String endDate) throws ParseException {

     List<Article>articles = getAllArticlesBetweenTwoDates(startDate ,endDate);//get the articles between the start and end date
    Date date1 = MyDate.ConvertStringToDate(startDate);
    Date date2 = MyDate.ConvertStringToDate(endDate);
    Set<String>websites = new HashSet<>();

     float  avgPerDay = 0;
     int numOfPosts = 0;
     int  totalMentions =0;
     long numOfDays = MyDate.getDifferenceDays(date1,date2); //get the number of days between two dates

    for (Article article:articles) {
        if(WordCounts.countOccurrences(article.description , keyword)>0||WordCounts.countOccurrences(article.title , keyword)>0){
            numOfPosts++;
        }
        totalMentions += WordCounts.countOccurrences(article.description , keyword);
        totalMentions += WordCounts.countOccurrences(article.title , keyword);
        websites.add(article.website);
    }
    avgPerDay = (float)totalMentions/(numOfDays+1);


     CSVWriter writer = new CSVWriter("Keywords.csv");
    // writer.WriteLine(keyword ,totalMentions, avgPerDay ,  numOfPosts , startDate ,endDate);

     return new Keyword(websites,keyword,totalMentions,avgPerDay,numOfPosts,date1,date2);
}

}
