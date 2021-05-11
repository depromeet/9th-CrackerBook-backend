package com.depromeet.crackerbook.service.user;

import com.depromeet.crackerbook.common.ErrorCode;
import com.depromeet.crackerbook.config.auth.TokenType;
import com.depromeet.crackerbook.controller.user.dto.KakaoUserDto;
import com.depromeet.crackerbook.domain.user.SnsType;
import com.depromeet.crackerbook.domain.user.User;
import com.depromeet.crackerbook.domain.user.repository.UserRepository;
import com.depromeet.crackerbook.exception.ApiException;
import com.depromeet.crackerbook.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    @Transactional
    public User signInKakao(KakaoUserDto kakaoUserDto) {
        String kakaoId = String.valueOf(kakaoUserDto.getId());
        String email = kakaoUserDto.getKakao_account().getEmail();

        User user = userRepository
                .findBySnsTypeAndSnsId(SnsType.KAKAO, kakaoId)
                .orElse(User.builder(SnsType.KAKAO, kakaoId, email).build());
        return userRepository.save(user);
    }

    @Transactional
    public String updateToken(User user, UserDetails userDetails) {
        return user.updateToken(
                JwtUtil.generateToken(userDetails, TokenType.ACCESS_TOKEN),
                JwtUtil.generateToken(userDetails, TokenType.REFRESH_TOKEN));
    }

    public void authenticate(String email) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, email));
        } catch (BadCredentialsException e) {
            throw new ApiException(ErrorCode.INVALD_USER);
        }
    }
}
