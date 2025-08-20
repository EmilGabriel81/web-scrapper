package com.scrapper.scrapper.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class BookDTO {
    private String title;
    private double price;
}
