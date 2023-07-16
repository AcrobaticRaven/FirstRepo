package org.example.InstagramBackendApplication.Controller;

import org.example.InstagramBackendApplication.Model.Post;
import org.example.InstagramBackendApplication.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PostService postService;


    @PostMapping("post")
    public String savePost(Post post, String mail){
        return postService.savePost(post, mail);
    }

    @GetMapping("post")
    public Post getPostById(Integer Id){
        return postService.getPostById(Id);
    }
}
