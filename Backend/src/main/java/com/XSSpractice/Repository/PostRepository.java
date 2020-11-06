package com.XSSpractice.Repository;

import com.XSSpractice.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Long, Post> {
    public Page<Post> findAllPost(Pageable pageable);
}
