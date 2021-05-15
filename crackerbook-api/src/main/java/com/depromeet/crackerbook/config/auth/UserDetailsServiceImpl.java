package com.depromeet.crackerbook.config.auth;

import com.depromeet.crackerbook.common.ErrorCode;
import com.depromeet.crackerbook.domain.user.repository.UserRepository;
import com.depromeet.crackerbook.exception.NotFoundApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(email)
                .map(entity -> new SecurityUser(entity.getEmail()))
                .orElseThrow(() -> new NotFoundApiException(ErrorCode.INVALID_USER));
    }
}
