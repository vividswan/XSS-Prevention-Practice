package com.XSSpractice.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostUpdateDto {

    private String title;
    private String content;

    @Builder
    PostUpdateDto(String title, String content){
        this.title = title;
        this.content = content;
    }

}
