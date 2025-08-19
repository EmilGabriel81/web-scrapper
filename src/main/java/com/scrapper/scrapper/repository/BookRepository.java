package com.scrapper.scrapper.repository;

import com.scrapper.scrapper.entity.BookEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class BookRepository {
    private final static String BOOKS_URL = "http://books.toscrape.com/";

    public List<BookEntity> findAll() {

        try {
            Document doc = Jsoup.connect(BOOKS_URL).get();
            Elements books = doc.select(".product_pod");

            for (Element book : books) {
                String title = book.select("h3 > a").text();
                String price = book.select(".price_color").text();
                String pr = price.substring(1);
                double finalPrice = Double.parseDouble(pr);

                BookEntity bookEntity = BookEntity.builder().withTitle(title).withPrice(finalPrice).build();

          //      BookEntity bookEntity = new BookEntity();

                if (finalPrice < 25) {
                    System.out.println(title + " - " + price);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
