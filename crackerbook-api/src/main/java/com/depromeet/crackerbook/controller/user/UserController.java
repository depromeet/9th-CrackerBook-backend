package com.depromeet.crackerbook.controller.user;

import com.depromeet.crackerbook.config.auth.UserDetailsServiceImpl;
import com.depromeet.crackerbook.controller.SuccessResponse;
import com.depromeet.crackerbook.controller.user.dto.KakaoUserDto;
import com.depromeet.crackerbook.controller.user.dto.request.SignInKakaoRequest;
import com.depromeet.crackerbook.controller.user.dto.request.UpdateUserInfoRequest;
import com.depromeet.crackerbook.controller.user.dto.response.BookLikeListResponse;
import com.depromeet.crackerbook.controller.user.dto.response.SignInKakaoResponse;
import com.depromeet.crackerbook.controller.user.dto.response.StudyLikeListResponse;
import com.depromeet.crackerbook.controller.user.dto.response.UserResponse;
import com.depromeet.crackerbook.domain.book.dto.BookLikeDto;
import com.depromeet.crackerbook.domain.study.dto.StudyLikeDto;
import com.depromeet.crackerbook.domain.user.User;
import com.depromeet.crackerbook.service.book.BookLikeService;
import com.depromeet.crackerbook.service.kakao.KakaoService;
import com.depromeet.crackerbook.service.study.StudyLikeService;
import com.depromeet.crackerbook.service.user.UserService;
import com.depromeet.crackerbook.util.RequestUtil;
import com.querydsl.core.QueryResults;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final KakaoService kakaoService;
    private final UserService userService;
    private final StudyLikeService studyLikeService;
    private final BookLikeService bookLikeService;
    private final UserDetailsServiceImpl userDetailsService;

    @Operation(summary = "카카오 로그인")
    @PostMapping("/sign-in/kakao")
    public SuccessResponse<SignInKakaoResponse> signInKakao(@RequestBody SignInKakaoRequest dto, HttpServletRequest request) {
        dto.validate();

        KakaoUserDto kakaoUserDto = kakaoService.kakaoLogin(dto, request.getHeader("origin"));
        User user = userService.signInKakao(kakaoUserDto);

        String email = user.getEmail();
        userService.authenticate(email);
        userDetailsService.loadUserByUsername(email);

        String accessToken = userService.updateToken(user);
        var response = SignInKakaoResponse.from(accessToken);

        return new SuccessResponse<>(response);
    }

    @Operation(summary = "사용자 정보 조회")
    @GetMapping("/{userId}")
    public SuccessResponse<UserResponse> getUserInfo(@PathVariable Long userId) {
        User user = userService.findUserById(userId);
        var response = UserResponse.from(user);

        return new SuccessResponse<>(response);
    }

    @Operation(summary = "사용자 정보 수정")
    @PutMapping("/{userId}")
    public SuccessResponse<UserResponse> updateUserInfo(@PathVariable Long userId, @RequestBody UpdateUserInfoRequest dto) {
        User user = userService.updateUser(userId, dto);
        var response = UserResponse.from(user);

        return new SuccessResponse<>(response);
    }

    @Operation(summary = "나의 관심 스터디 목록 조회")
    @GetMapping("/me/like/studies")
    public SuccessResponse<StudyLikeListResponse> getMyStudyLikeList(
            HttpServletRequest request
            , @Parameter(description = "페이지", required = true) @RequestParam int page
            , @Parameter(description = "개수", required = true) @RequestParam int size
    ) {
        Long userId = RequestUtil.getUserId(request);

        PageRequest pageRequest = PageRequest.of(page, size);
        QueryResults<StudyLikeDto> results = studyLikeService.getStudyLikeList(userId, pageRequest);
        var response = StudyLikeListResponse.of(results.getTotal(), results.getResults());

        return new SuccessResponse<>(response);
    }

    @Operation(summary = "나의 관심 책 목록 조회")
    @GetMapping("/me/like/books")
    public SuccessResponse<BookLikeListResponse> getMyBookLikeList(
            HttpServletRequest request
            , @Parameter(description = "페이지", required = true) @RequestParam int page
            , @Parameter(description = "개수", required = true) @RequestParam int size
    ) {
        Long userId = RequestUtil.getUserId(request);

        PageRequest pageRequest = PageRequest.of(page, size);
        QueryResults<BookLikeDto> results = bookLikeService.getBookLikeList(userId, pageRequest);
        var response = BookLikeListResponse.of(results.getTotal(), results.getResults());

        return new SuccessResponse<>(response);
    }
}
