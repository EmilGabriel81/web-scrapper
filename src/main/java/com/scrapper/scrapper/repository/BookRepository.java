package com.scrapper.scrapper.repository;

import org.common.dto.BookDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.common.constants.Constants.BOOKS_URL;

@Component
public class BookRepository {


    public CompletableFuture<List<BookDTO>> findAll() {

        List<BookDTO> books = null;

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
        return CompletableFuture.completedFuture(books);
    }
}
