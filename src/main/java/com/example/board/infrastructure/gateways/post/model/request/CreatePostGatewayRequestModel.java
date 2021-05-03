package com.example.board.infrastructure.gateways.post.model.request;

import com.example.board.core.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CreatePostGatewayRequestModel {
    private final String title;
    private final String content;
    private final LocalDate createdAt;
    private final int view;
    private final boolean isDeleted;
    private final boolean isPublic;

    public static CreatePostGatewayRequestModel of(Post post) {
        return new CreatePostGatewayRequestModel(
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                post.getView(),
                post.isDeleted(),
                post.isPublic());
    }
}
