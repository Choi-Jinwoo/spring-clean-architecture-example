package com.example.board.core.use_cases.post;

import com.example.board.core.entities.Post;
import com.example.board.core.use_cases.post.model.response.PostResponseModel;
import com.example.board.infrastructure.gateways.post.PostGateway;
import com.example.board.infrastructure.gateways.post.model.response.PostGatewayResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindVisiblePostsInteractor implements FindVisiblePostsInputBoundary {
    private final PostGateway postGateway;

    public FindVisiblePostsInteractor(PostGateway postGateway) {
        this.postGateway = postGateway;
    }

    @Override
    public List<PostResponseModel> create() {
        List<PostGatewayResponseModel> postGatewayResponseModels = postGateway.findAll();

        List<Post> posts = postGatewayResponseModels
                .stream()
                .map(PostGatewayResponseModel::fromThis)
                .collect(Collectors.toList());

        List<PostResponseModel> postResponseModels = posts
                .stream()
                .filter(Post::canShow)
                .map(PostResponseModel::of)
                .collect(Collectors.toList());

        return postResponseModels;
    }
}

