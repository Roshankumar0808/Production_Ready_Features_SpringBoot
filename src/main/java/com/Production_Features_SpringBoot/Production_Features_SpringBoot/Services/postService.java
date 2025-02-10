package com.Production_Features_SpringBoot.Production_Features_SpringBoot.Services;

import com.Production_Features_SpringBoot.Production_Features_SpringBoot.DTO.postDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface postService  {
    List<postDto> getAllPost();
    postDto createNewPost(postDto inputPost);

    postDto getPostById(Long postId);

    postDto updateDetails(postDto input, Long postId);
}
