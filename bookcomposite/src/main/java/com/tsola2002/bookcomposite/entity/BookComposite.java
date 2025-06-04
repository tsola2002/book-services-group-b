package com.tsola2002.bookcomposite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookComposite {

    private Map<String, Object> book;
    private List<Map<String, Object>> review;
    private List<Map<String, Object>> recommendation;
}
