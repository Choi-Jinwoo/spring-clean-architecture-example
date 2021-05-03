package com.example.board.infrastructure.tables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "post")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "view")
    private Integer view;

    @Column(name = "is_deleted", columnDefinition = "tinyint")
    private Boolean isDeleted;

    @Column(name = "is_public", columnDefinition = "tinyint")
    private Boolean isPublic;
}
