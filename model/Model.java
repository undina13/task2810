package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private View view;
    private Provider [] providers;

    public Model(View view, Provider... providers) {
        if (view == null || providers == null || providers.length == 0) {
            throw new IllegalArgumentException();
        }
        this.view = view;
        this.providers = providers;

    }

    public  void selectCity(String city){
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        for (Provider pr:providers
             ) {
          vacancies.addAll(pr.getJavaVacancies(city));

        }
        view.update(vacancies);

    }
}
