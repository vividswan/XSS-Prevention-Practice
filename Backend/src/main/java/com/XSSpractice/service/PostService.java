package com.XSSpractice.service;

import com.XSSpractice.Repository.PostRepository;
import com.XSSpractice.dto.PostUpdateDto;
import com.XSSpractice.dto.PostWriteDto;
import com.XSSpractice.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public Page<Post> findAll(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    @Transactional
    public void postWrite(PostWriteDto postWriteDto){
        postRepository.save(postWriteDto.toEntity());
    }

    @Transactional
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    public void update(long id, PostUpdateDto postUpdateDto) {
        Post requestPost = postRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("해당 id의 게시글이 없습니다.");
        });
        requestPost.update(postUpdateDto.getTitle(), postUpdateDto.getContent());
    }

    @Transactional(readOnly = true)
    public Post findById(long id) {
        Post requestPost =  postRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("해당 게시물이 없습니다.");
        });
        return requestPost;
    }
}
