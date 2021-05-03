package com.example.board.infrastructure.controllers;

import com.example.board.core.use_cases.post.CreatePostInputBoundary;
import com.example.board.core.use_cases.post.FindVisiblePostsInputBoundary;
import com.example.board.core.use_cases.post.model.request.CreatePostRequestModel;
import com.example.board.core.use_cases.post.model.response.PostResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {
    private final CreatePostInputBoundary createPostInputBoundary;
    private final FindVisiblePostsInputBoundary findVisiblePostsInputBoundary;

    public PostController(CreatePostInputBoundary createPostInputBoundary, FindVisiblePostsInputBoundary findVisiblePostsInputBoundary) {
        this.createPostInputBoundary = createPostInputBoundary;
        this.findVisiblePostsInputBoundary = findVisiblePostsInputBoundary;
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<PostResponseModel> postResponseModels = findVisiblePostsInputBoundary.create();

        return ResponseEntity
                .ok()
                .body(postResponseModels);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody  CreatePostRequestModel createPostRequestModel) {
        createPostInputBoundary.create(createPostRequestModel);

        return ResponseEntity
                .ok()
                .build();
    }
}
