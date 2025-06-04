package com.example.mofe.bookservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_BOOK")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COL_BOOK_ID")
    private Integer bookId;

    @Column(name = "COL_BOOK_NAME", nullable = false)
    private String name;

    @Column(name = "COL_BOOK_WEIGHT", nullable = false)
    private String weight;
}
