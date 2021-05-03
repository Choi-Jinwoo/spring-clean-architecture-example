package com.example.board.infrastructure.gateways.post;

import com.example.board.infrastructure.gateways.post.model.request.CreatePostGatewayRequestModel;
import com.example.board.infrastructure.gateways.post.model.response.PostGatewayResponseModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostGateway {
    void create(CreatePostGatewayRequestModel createPostGatewayRequestModel);
    List<PostGatewayResponseModel> findAll();
}
