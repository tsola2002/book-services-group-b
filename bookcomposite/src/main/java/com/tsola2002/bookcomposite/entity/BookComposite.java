package com.tsola2002.bookcomposite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bookcomposite")
public class BookComposite {

    @Id
    private String id;

//    private Map<String, Object> book;
//    private List<Map<String, Object>> review;
    private List<Map<String, Object>> recommendation;
}