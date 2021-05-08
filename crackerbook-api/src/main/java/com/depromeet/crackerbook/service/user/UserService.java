package com.depromeet.crackerbook.service.user;

import com.depromeet.crackerbook.controller.user.dto.KakaoUserDto;
import com.depromeet.crackerbook.domain.user.SnsType;
import com.depromeet.crackerbook.domain.user.User;
import com.depromeet.crackerbook.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void signInKakao(KakaoUserDto kakaoUserDto) {
        String kakaoId = String.valueOf(kakaoUserDto.getId());
        KakaoUserDto.KakaoAccount kakaoAccount = kakaoUserDto.getKakao_account();

        User user = userRepository.findBySnsTypeAndSnsId(SnsType.KAKAO, kakaoId);
        upsertUser(kakaoId, kakaoAccount, user);
    }

    private void upsertUser(String kakaoId, KakaoUserDto.KakaoAccount kakaoAccount, User user) {
        if (ObjectUtils.isEmpty(user)) {
            user = User.builder(SnsType.KAKAO, kakaoId, kakaoAccount.getEmail()).build();
        } else {
            // TODO: create token
            user.setAccessToken("");
            user.setRefreshToken("");
        }
        userRepository.save(user);
    }
}
