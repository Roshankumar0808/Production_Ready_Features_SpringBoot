package com.Production_Features_SpringBoot.Production_Features_SpringBoot.Services;

import com.Production_Features_SpringBoot.Production_Features_SpringBoot.DTO.postDto;
import com.Production_Features_SpringBoot.Production_Features_SpringBoot.Entity.PostEntity;
import com.Production_Features_SpringBoot.Production_Features_SpringBoot.Exception.ResourceNotFoundException;
import com.Production_Features_SpringBoot.Production_Features_SpringBoot.Repositories.postRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class postServiceImpl implements postService{
    private final postRepo postRepo;
    private final ModelMapper modelMapper;

    public postServiceImpl(com.Production_Features_SpringBoot.Production_Features_SpringBoot.Repositories.postRepo postRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
    }



    @Override
    public List<postDto> getAllPost() {
       return postRepo.findAll().stream().map(post->modelMapper.map(post, postDto.class)).collect(Collectors.toList());

    }

    @Override
    public postDto createNewPost(postDto inputPost) {
        PostEntity postEntity=modelMapper.map(inputPost,PostEntity.class);
        return modelMapper.map(postRepo.save(postEntity),postDto.class);

    }

    @Override
    public postDto getPostById(Long postId) {
       PostEntity postEntity=postRepo
               .findById(postId)
               .orElseThrow(()->new ResourceNotFoundException("Post Not found with id"+postId));
       return modelMapper.map(postEntity, postDto.class);
    }

    @Override
    public postDto updateDetails(postDto input, Long postId) {
       PostEntity olderpost=postRepo.findById(postId).orElseThrow(()->new RuntimeException("Post Not Found with id "+postId));
       input.setId(postId);
       modelMapper.map(input,olderpost);
       PostEntity newpost=postRepo.save(olderpost);
       return modelMapper.map(newpost, postDto.class);

    }




}
