package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View{
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        try{
            updateFile(getUpdatedFileContent(vacancies));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;

    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Одесса");
    }

    private String getUpdatedFileContent(List<Vacancy> list){
        return null;
    }

    private void updateFile(String s){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(s);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
