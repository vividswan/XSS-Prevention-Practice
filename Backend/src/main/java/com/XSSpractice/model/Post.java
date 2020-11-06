package com.XSSpractice.model;

import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String content;

    @CreatedDate
    private LocalDateTime createdTime;

    private String User;
}
