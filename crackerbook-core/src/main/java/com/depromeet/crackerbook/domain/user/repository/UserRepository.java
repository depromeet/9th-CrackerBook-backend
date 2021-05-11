package com.depromeet.crackerbook.domain.user.repository;

import com.depromeet.crackerbook.domain.user.SnsType;
import com.depromeet.crackerbook.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findBySnsTypeAndSnsId(SnsType snsType, String snsId);
    Optional<User> findByEmail(String email);
}
