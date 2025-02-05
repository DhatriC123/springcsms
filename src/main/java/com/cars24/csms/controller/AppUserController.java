package com.cars24.csms.controller;

import com.cars24.csms.data.dao.Impl.AppUserDetailsDaoImpl;
import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.data.resp.LoginResponse;
import com.cars24.csms.services.impl.AppUserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
@Slf4j

public class AppUserController {
    private final AppUserDetailsDaoImpl appUserDao;
    private final AppUserServiceImpl appUserService;

    @GetMapping ("/Login")
    public  ResponseEntity<LoginResponse>  getUsers(@Valid @RequestBody LoginReq loginRequest){
        appUserDao.getUserDetails(loginRequest);
        return ResponseEntity.ok().body(null);
    }
    @PostMapping ("/Signup")
    public ResponseEntity<ApiResponse> signUp(@Valid @RequestBody SignUpReq signUpRequest){
        log.info("[signUp]  signUpRequest {}",signUpRequest);
        return appUserService.signUp(signUpRequest);
    }


}
