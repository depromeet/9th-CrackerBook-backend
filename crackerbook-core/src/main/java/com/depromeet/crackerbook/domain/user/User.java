package com.depromeet.crackerbook.domain.user;

import com.depromeet.crackerbook.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String email;
    private String nickName;
    private String imageUrl;
    private String introduce;
    private String snsType;
    private String snsId;
    private String accessToken;
    private String refreshToken;
}
