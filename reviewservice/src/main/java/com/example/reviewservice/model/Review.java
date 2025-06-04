package com.example.reviewservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reviews")
public class Review {

    @Id
    private String reviewId;

    @Field("COL_BOOK_ID")
    private int bookId;

    @Field("COL_AUTHOR")
    private String author;

    @Field("COL_SUBJECT")
    private String subject;

    @Field("COL_CONTENT")
    private String content;
}
