package com.example.board.infrastructure.gateways.post.model.response;

import com.example.board.core.entities.Post;
import com.example.board.infrastructure.gateways.post.model.request.CreatePostGatewayRequestModel;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class PostGatewayResponseModel {
    private final String title;
    private final String content;
    private final LocalDate createdAt;
    private final int view;
    private final boolean isDeleted;
    private final boolean isPublic;

    public Post fromThis() {
        return new Post(
                title,
                content,
                createdAt,
                view,
                isDeleted,
                isPublic
        );
    }

}
