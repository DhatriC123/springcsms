package com.cars24.csms.services.impl;

import com.cars24.csms.data.dao.Impl.AppUserDetailsDaoImpl;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.ApiResponse;
import com.cars24.csms.exceptions.UserServiceException;
import com.cars24.csms.services.AppUserService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserDetailsDaoImpl appUserDao;
    private final AppUserRepository appUserRepository;


    public ResponseEntity<ApiResponse> signUp(SignUpReq signUpRequest) {
        ApiResponse apiResponse = new ApiResponse();
        log.info("[signUp] IN SERVICE : {} ",signUpRequest);
        if (appUserDao.checkIfUserExists(signUpRequest)) {
            //if exists
            throw new UserServiceException("User already exists");
        } else {
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setSuccess(true);
            apiResponse.setMessage("User signed up successfully");
            apiResponse.setService("APPUSR-" + HttpStatus.OK.value());
            apiResponse.setData(null);

            appUserDao.RegisterUser(signUpRequest);

            return ResponseEntity.ok().body(apiResponse);
        }

    }
}







