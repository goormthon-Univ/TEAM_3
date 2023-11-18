package com.allergenie.server.controller;

import com.allergenie.server.config.jwt.JwtTokenProvider;
import com.allergenie.server.domain.User;
import com.allergenie.server.dto.response.MedicineInfoDto;
import com.allergenie.server.dto.response.MyPageDto;
import com.allergenie.server.service.MyPageService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mypage")
public class MyPageController {

    private final MyPageService myPageService;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping
    public MyPageDto getMyPage(HttpServletRequest request) {
        User user = jwtTokenProvider.getUserInfoByToken(request);
        return myPageService.getMyPage(user);
    }

    //약 정보 나타내기
    @GetMapping("/{medicineId}")
    public MedicineInfoDto getProhibitionInfo(@PathVariable Long medicineId) {
        return myPageService.getProhibitionInfo(medicineId);
    }


    //약 정보 추가하기
}
