package com.tsola2002.recommendationservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COL_BOOK_ID")
    private int bookId;

    @Column(name = "COL_RECOMMENDATION_ID")
    private int recommendationId;

    @Column(name = "COL_AUTHOR")
    private String author;

    @Column(name = "COL_RATE")
    private int rate;

    @Column(name = "COL_CONTENT")
    private String content;
}
