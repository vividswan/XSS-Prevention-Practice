package com.XSSpractice.dto;

import com.XSSpractice.model.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostWriteDto {
    private String user;
    private String title;
    private String content;

    @Builder
    PostWriteDto(String user, String title, String content){
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public Post toEntity(){
        return Post.builder()
                .user(user)
                .title(title)
                .content(content)
                .build();
    }

}
