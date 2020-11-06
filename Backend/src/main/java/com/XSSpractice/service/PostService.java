package com.XSSpractice.service;

import com.XSSpractice.Repository.PostRepository;
import com.XSSpractice.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private PostRepository postRepository;

    @Transactional
    public Page<Post> getAllPosts(Pageable pageable){
        return postRepository.findAllPost(pageable);
    }
}
