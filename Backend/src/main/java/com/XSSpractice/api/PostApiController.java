package com.XSSpractice.api;

import com.XSSpractice.dto.PostUpdateDto;
import com.XSSpractice.dto.PostWriteDto;
import com.XSSpractice.model.Post;
import com.XSSpractice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/write")
    public int postWrite(@RequestBody PostWriteDto postWriteDto){
        postService.postWrite(postWriteDto);
        return HttpStatus.OK.value();
    }

    @DeleteMapping("/api/v1/delete/{id}")
    public int postDelete(@PathVariable long id){
        postService.deletePost(id);
        return HttpStatus.OK.value();
    }

    @GetMapping("/api/v1/read")
    public Page<Post> findAll(@PageableDefault(size=5, sort="id", direction = Sort.Direction.DESC)Pageable pageable){
        return postService.findAll(pageable);
    }

    @PutMapping("/api/v1/update/{id}")
    public int update(@PathVariable long  id, PostUpdateDto postUpdateDto){
        postService.update(id, postUpdateDto);
        return HttpStatus.OK.value();
    }

}
