package com.Production_Features_SpringBoot.Production_Features_SpringBoot.Controllers;

import com.Production_Features_SpringBoot.Production_Features_SpringBoot.DTO.postDto;
import com.Production_Features_SpringBoot.Production_Features_SpringBoot.Services.postService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/anypath")

public class postController {
   private final postService postService;

    public postController(com.Production_Features_SpringBoot.Production_Features_SpringBoot.Services.postService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<postDto> getAllpost(){
        return postService.getAllPost();
    }

    @GetMapping("/{postId}")
    public postDto getpostbyId(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    @PostMapping
    public postDto postDetails(@RequestBody postDto input){

        return postService.createNewPost(input);
    }

}
