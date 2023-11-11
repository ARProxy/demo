package com.example.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@RequiredArgsConstructor
@Table(name = "users")
@Entity
public class UsersEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "pw")
    private String pw;

    @Column(name = "nickname")
    private String nickname;

    @Builder
    public UsersEntity(String userId, String pw, String nickname) {
        this.userId = userId;
        this.pw = pw;
        this.nickname = nickname;
    }
}