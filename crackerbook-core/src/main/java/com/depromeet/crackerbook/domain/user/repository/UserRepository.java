package com.depromeet.crackerbook.domain.user.repository;

import com.depromeet.crackerbook.domain.user.SnsType;
import com.depromeet.crackerbook.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findBySnsTypeAndSnsId(SnsType snsType, String snsId);
}
