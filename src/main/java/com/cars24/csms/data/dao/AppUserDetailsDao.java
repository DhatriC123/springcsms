package com.cars24.csms.data.dao;

import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;
import org.springframework.stereotype.Service;

@Service
public interface AppUserDetailsDao {
    String getUserDetails(LoginReq loginReq);
    void RegisterUser(SignUpReq signUpRequest);
    Boolean checkIfUserExists(SignUpReq signUpRequest);

}
