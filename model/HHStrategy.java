package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy  implements Strategy{
    private static   final String URL_FORMAT = "https://grc.ua/search/vacancy?text=java+%s&page=%d";


    @Override
    public List<Vacancy> getVacancies(String searchString) {

            List<Vacancy> vacancies = new ArrayList<>();
            try {
                int pageNumber = 0;
                Document doc;
                while (true) {
                    doc = getDocument(searchString, pageNumber++);
                    if (doc == null)
                        break;

                    Elements elements = doc.select("[data-qa=vacancy-serp__vacancy]");
                    if (elements.size() == 0) break;

                    for (Element element : elements) {
                        // title
                        Element titleElement = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                        String title = titleElement.text();

                        // salary
                        Element salaryElement = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                        String salary = "";
                        if (salaryElement != null) {
                            salary = salaryElement.text();
                        }

                        // city
                        String city = element.select("[data-qa=vacancy-serp__vacancy-address]").first().text();

                        // company
                        String companyName = element.select("[data-qa=vacancy-serp__vacancy-employer]").first().text();

                        // site
                        String siteName = "https://grc.ua/";

                        // url
                        String url = titleElement.attr("href");


                        // add vacancy to the list
                        Vacancy vacancy = new Vacancy();
                        vacancy.setTitle(title);
                        vacancy.setSalary(salary);
                        vacancy.setCity(city);
                        vacancy.setCompanyName(companyName);
                        vacancy.setSiteName(siteName);
                        vacancy.setUrl(url);
                        vacancies.add(vacancy);

//                        System.out.println("Title = " + title);
//                        System.out.println("Salary = " + salary);
//                        System.out.println("City = " + city);
//                        System.out.println("CompanyName = " + companyName);
//                        System.out.println("SiteName = " + siteName);
//                        System.out.println("URL = " + url);
//                        System.out.println();
//                        System.out.println();
                    }

                    //break;
                }
            }
            catch (Exception e) {
                //e.printStackTrace();
            }

            return vacancies;
        }


   protected Document getDocument(String searchString, int page) throws IOException{
        Document doc = Jsoup.connect(String.format(URL_FORMAT, searchString, page)).
                userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36")
                .referrer("")
                .get();
        return doc;
    }
}
