package com.example.board.core.use_cases.post.model.response;

import com.example.board.core.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PostResponseModel {
    private final String title;
    private final String content;
    private final LocalDate createdAt;
    private final int view;
    private final boolean isDeleted;
    private final boolean isPublic;

    public static PostResponseModel of(Post post) {
        return new PostResponseModel(
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                post.getView(),
                post.isDeleted(),
                post.isPublic()
        );
    }
}
