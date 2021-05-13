package com.depromeet.crackerbook.domain.user;

import com.depromeet.crackerbook.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String email;
    private String nickname;
    private String imageUrl;
    private String introduce;

    @Enumerated(EnumType.STRING)
    private SnsType snsType;

    private String snsId;
    private String accessToken;
    private String refreshToken;

    public static UserBuilder builder(SnsType snsType, String snsId, String email) {
        return new UserBuilder()
                .snsType(snsType)
                .snsId(snsId)
                .email(email);
    }

    public String updateToken(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;

        return this.accessToken;
    }

    public User updateInfo(String nickname, String imageUrl, String introduce) {
        this.nickname = nickname;
        this.imageUrl = imageUrl;
        this.introduce = introduce;

        return this;
    }
}
