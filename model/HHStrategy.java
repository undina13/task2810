package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy  implements Strategy{
    private static   final String URL_FORMAT = "https://grc.ua/search/vacancy?text=java+%s&page=%d";


    @Override
    public List<Vacancy> getVacancies(String searchString) {
        try {
            Document doc = Jsoup.connect(URL_FORMAT).
                    userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36")
                    .referrer("")
                    .get();




        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
