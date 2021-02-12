package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Provider;

public class Aggregator {

    public static void main(String[] args) {
        Provider provider = new Provider(null);
        Controller controller = new Controller(provider);

        controller.scan();
        new HHStrategy().getVacancies("https://hh.ru/search/vacancy?text=java+Kiev&page=1");

    }
}
