package com.example.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@RequiredArgsConstructor
@Table(name = "auth")
@Entity
public class AuthEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "refreshToken")
    private String refreshToken;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UsersEntity usersEntity;

    @Builder
    public AuthEntity(String refreshToken, UsersEntity usersEntity) {
        this.refreshToken = refreshToken;
        this.usersEntity = usersEntity;
    }
    public void refreshUpdate(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
