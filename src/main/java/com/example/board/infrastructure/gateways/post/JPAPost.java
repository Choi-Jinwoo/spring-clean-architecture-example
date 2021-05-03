package com.example.board.infrastructure.gateways.post;

import com.example.board.infrastructure.gateways.post.model.request.CreatePostGatewayRequestModel;
import com.example.board.infrastructure.gateways.post.model.response.PostGatewayResponseModel;
import com.example.board.infrastructure.repositories.JPAPostRepository;
import com.example.board.infrastructure.tables.PostTable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JPAPost implements PostGateway {
    private final JPAPostRepository JPAPostRepository;

    public JPAPost(JPAPostRepository JPAPostRepository) {
        this.JPAPostRepository = JPAPostRepository;
    }

    @Override
    public void create(CreatePostGatewayRequestModel createPostGatewayRequestModel) {
        this.JPAPostRepository.save(new PostTable(
                null,
                createPostGatewayRequestModel.getTitle(),
                createPostGatewayRequestModel.getContent(),
                createPostGatewayRequestModel.getCreatedAt(),
                createPostGatewayRequestModel.getView(),
                createPostGatewayRequestModel.isDeleted(),
                createPostGatewayRequestModel.isPublic()
        ));
    }

    @Override
    public List<PostGatewayResponseModel> findAll() {
        return JPAPostRepository.findAll()
                .stream()
                .map(postTable -> new PostGatewayResponseModel(
                        postTable.getTitle(),
                        postTable.getContent(),
                        postTable.getCreatedAt(),
                        postTable.getView(),
                        postTable.getIsDeleted(),
                        postTable.getIsPublic()
                ))
                .collect(Collectors.toList());
    }
}
