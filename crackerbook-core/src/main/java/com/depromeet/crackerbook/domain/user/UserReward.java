package com.depromeet.crackerbook.domain.user;

import com.depromeet.crackerbook.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserReward extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_reward_id")
    private Long id;

    private Long userId;
    private Long rewardId;

    public UserReward(Long userId, Long rewardId) {
        this.userId = userId;
        this.rewardId = rewardId;
    }
}
