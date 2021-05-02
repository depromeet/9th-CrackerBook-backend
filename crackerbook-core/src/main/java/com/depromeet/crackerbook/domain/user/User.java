package com.depromeet.crackerbook.domain.user;

import com.depromeet.crackerbook.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String email;
    private String nickName;
    private String imageUrl;
    private String introduce;
    private String snsType;
    private String snsId;
    private String accessToken;
    private String refreshToken;

    public User(
        String email,
        String nickName,
        String imageUrl,
        String introduce,
        String snsType,
        String snsId,
        String accessToken,
        String refreshToken
    ) {
        this.email = email;
        this.nickName = nickName;
        this.imageUrl = imageUrl;
        this.introduce = introduce;
        this.snsType = snsType;
        this.snsId = snsId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_reward_id")
    private List<UserReward> userRewardList = new ArrayList<>();
}
