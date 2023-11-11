package com.example.service;

import com.example.entity.AuthEntity;
import com.example.entity.UsersEntity;
import com.example.jwt.TokenUtils;
import com.example.repository.AuthRepository;
import com.example.repository.UsersRepository;
import com.example.dto.TokenResponse;
import com.example.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;
    private final TokenUtils tokenUtils;
    private final AuthRepository authRepository;

    public Optional<UsersEntity> findByUserId(String userId) {

        return usersRepository.findByUserId(userId);
    }

    @Transactional
    public TokenResponse signUp(UserRequest userRequest) {
        UsersEntity usersEntity =
                usersRepository.save(
                        UsersEntity.builder()
                                .pw(userRequest.getUserPw())
                                .userId(userRequest.getUserId())
                                .build());

        String accessToken = tokenUtils.generateJwtToken(usersEntity);
        String refreshToken = tokenUtils.saveRefreshToken(usersEntity);

        authRepository.save(
                AuthEntity.builder().usersEntity(usersEntity).refreshToken(refreshToken).build());

        return TokenResponse.builder().ACCESS_TOKEN(accessToken).REFRESH_TOKEN(refreshToken).build();
    }

    @Transactional
    public TokenResponse signIn(UserRequest userRequest) {
        UsersEntity usersEntity =
                usersRepository
                        .findByUserIdAndPw(userRequest.getUserId(), userRequest.getUserPw())
                        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        AuthEntity authEntity =
                authRepository
                        .findByUsersEntityId(usersEntity.getId())
                        .orElseThrow(() -> new IllegalArgumentException("Token 이 존재하지 않습니다."));
        String accessToken = "";
        String refreshToken= authEntity.getRefreshToken();

        if (tokenUtils.isValidRefreshToken(refreshToken)) {
            accessToken = tokenUtils.generateJwtToken(authEntity.getUsersEntity());
            return TokenResponse.builder()
                    .ACCESS_TOKEN(accessToken)
                    .REFRESH_TOKEN(authEntity.getRefreshToken())
                    .build();
        } else {
            refreshToken = tokenUtils.saveRefreshToken(usersEntity);
            authEntity.refreshUpdate(refreshToken);
        }

        return TokenResponse.builder().ACCESS_TOKEN(accessToken).REFRESH_TOKEN(refreshToken).build();
    }

    public List<UsersEntity> findUsers() {
        return usersRepository.findAll();
    }
}
