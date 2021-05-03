package com.example.board.core.use_cases.post;

import com.example.board.core.use_cases.post.model.request.CreatePostRequestModel;
import com.example.board.core.use_cases.post.model.response.PostResponseModel;

import java.util.List;

public interface FindVisiblePostsInputBoundary {
    List<PostResponseModel> create();
}
