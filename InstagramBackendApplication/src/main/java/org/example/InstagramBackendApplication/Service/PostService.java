package org.example.InstagramBackendApplication.Service;

import org.example.InstagramBackendApplication.Model.Post;
import org.example.InstagramBackendApplication.Repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;

    public String savePost(Post post , String mail){
        post.setCreatedDate(LocalDateTime.now());
        post.setUpdatedDate(LocalDateTime.now());
        postRepo.save(post);
        return "Post saved";
    }

    public Post getPostById(Integer Id){
        return postRepo.findById(Id).orElse(null);
    }
}
