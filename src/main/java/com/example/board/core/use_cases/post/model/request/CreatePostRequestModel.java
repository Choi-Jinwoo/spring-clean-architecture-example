package com.example.board.core.use_cases.post.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreatePostRequestModel {
    private final String title;
    private final String content;
    private final boolean isPublic;
}
