package com.scrapper.scrapper.repository;

import com.scrapper.scrapper.entity.BookDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepository {

    private final static String BOOKS_URL = "http://books.toscrape.com/";

    public List<BookDTO> findAll() {

        List<BookDTO> books = null;
        if (true) {
            throw new RuntimeException("Simulated scrapper-service failure");
        }

        try {
            Document doc = Jsoup.connect(BOOKS_URL).get();
            Elements bookElements = doc.select(".product_pod");
            books = new ArrayList<>();

            for (Element book : bookElements) {
                String title = book.select("h3 > a").text();
                String price = book.select(".price_color").text();
                String pr = price.substring(1);
                double finalPrice = Double.parseDouble(pr);

                books.add(BookDTO.builder().withTitle(title).withPrice(finalPrice).build());
                if (finalPrice < 25) {
                    System.out.println(title + " - " + price);
                    //send email
                    //process information
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}
