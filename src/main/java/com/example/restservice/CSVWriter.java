package com.example.restservice;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CSVWriter {
    private FileOutputStream fileOutputStream ;
    private PrintWriter printWriter ;

    public CSVWriter(String path){
        try{
            fileOutputStream = new FileOutputStream(path , true);
            printWriter = new PrintWriter(fileOutputStream);
        }
        catch (Exception e){
            System.out.print(e);
        }
    }

    public void WriteLine(String keyword ,int totalMentions ,double avragePerDay , int numberOfPosts , String startDate ,String endDate){
        printWriter.println(keyword + ','+totalMentions +','+avragePerDay +','+numberOfPosts+','+startDate+','+endDate);
        printWriter.close();
        System.out.println("CSV file has been closed succsesfully");
    }
}
