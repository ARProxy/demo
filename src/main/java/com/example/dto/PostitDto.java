package com.example.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostitDto {

    private Long id;
    private Long boardId;
    private String postContents;
    private String postPicture;
    private LocalDateTime regDate;

}
