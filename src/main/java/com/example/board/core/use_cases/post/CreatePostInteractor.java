package com.example.board.core.use_cases.post;

import com.example.board.core.entities.Post;
import com.example.board.core.use_cases.post.model.request.CreatePostRequestModel;
import com.example.board.infrastructure.gateways.post.PostGateway;
import com.example.board.infrastructure.gateways.post.model.request.CreatePostGatewayRequestModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreatePostInteractor implements CreatePostInputBoundary {
    private final PostGateway postGateway;

    public CreatePostInteractor(PostGateway postGateway) {
        this.postGateway = postGateway;
    }

    @Override
    public void create(CreatePostRequestModel requestModel) {
        Post post = new Post(
                requestModel.getTitle(),
                requestModel.getContent(),
                LocalDate.now(),
                0,
                false,
                requestModel.isPublic());

        CreatePostGatewayRequestModel createPostGatewayRequestModel = CreatePostGatewayRequestModel.of(post);
        postGateway.create(createPostGatewayRequestModel);
    }

}
