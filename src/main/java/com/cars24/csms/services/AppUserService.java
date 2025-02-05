package com.cars24.csms.services;

import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.resp.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface AppUserService {
    ResponseEntity<ApiResponse> signUp(SignUpReq signUpRequest);
}
