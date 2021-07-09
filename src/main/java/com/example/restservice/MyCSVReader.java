package com.example.restservice;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MyCSVReader {

   FileReader fr ;
    CSVReader reader ;

    public MyCSVReader(String fileName) throws IOException {
        try{
        fr = new FileReader(fileName);
        reader = new CSVReader(fr);}
        catch (Exception e){
            System.err.println("Error opening the file");
        }
    }


    public  String[] ReadLine() throws IOException, CsvValidationException {
        String[] nextLine = null;
        try {
            nextLine = reader.readNext();

            }
        finally {
            return nextLine;
        }

    }
}
