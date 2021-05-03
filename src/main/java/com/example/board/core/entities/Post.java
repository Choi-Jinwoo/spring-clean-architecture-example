package com.example.board.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Post {
    private final String title;
    private final String content;
    private final LocalDate createdAt;
    private int view;
    private boolean isDeleted;
    private final boolean isPublic;

    public boolean canShow() {
        return !isDeleted && isPublic;
    }

    public void delete() {
        this.isDeleted = true;
    }

    public void increaseView() {
        this.view += 1;
    }
}
