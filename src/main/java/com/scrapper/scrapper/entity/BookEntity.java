package com.scrapper.scrapper.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class BookEntity {
    private String title;
    private double price;
}
