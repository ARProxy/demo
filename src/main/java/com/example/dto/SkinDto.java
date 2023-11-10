package com.example.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkinDto {

    private Long id;
    private Long boardId;
    private String skin;
}
