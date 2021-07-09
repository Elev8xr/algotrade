package com.example.restservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
//these controller call the loadup data methods before starting the server
@Component
public class CrawlerController implements CommandLineRunner {
    CrawlerManager manager;

    public CrawlerController(){
        manager = CrawlerManager.getInstance();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("HELLLLLLLLLLLLLLLLLLO IAM HERE");
       manager.LoadUpDataFromArticlesFile(); // load the articles
        manager.sortArticlesByDate();



    }
}
