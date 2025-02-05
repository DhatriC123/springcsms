package com.cars24.csms.data.dao.Impl;

import com.cars24.csms.data.dao.AppUserDetailsDao;
import com.cars24.csms.data.entities.AppUserDetails;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.LoginReq;
import com.cars24.csms.data.req.SignUpReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor

public class AppUserDetailsDaoImpl implements AppUserDetailsDao {

    private final AppUserRepository appUserRepository;

   //@Override
    public String getUserDetails(LoginReq loginRequest){
        AppUserDetails appUserDetails = appUserRepository.findAppUserDetailsByNameAndPassword(loginRequest.getUsername(),loginRequest.getPassword());
        log.info(String.valueOf(appUserDetails));
        return null;
    }

    public void RegisterUser(SignUpReq signUpRequest)
    {
        //ObjectMapper objectMapper = new ObjectMapper();
        //AppUserDetails appUserDetails = objectMapper.convertValue(signUpRequest,AppUserDetails.class);
        //appUserDetails.setId(0);
//        log.info("[RegisterUser] IN DAO: {}",signUpRequest);
        AppUserDetails appUserDetails = new AppUserDetails();

//        appUserDetails.setId(0);
        appUserDetails.setIsactive(true);
        appUserDetails.setName(signUpRequest.getUsername());
        appUserDetails.setPassword(signUpRequest.getPassword());
        appUserRepository.save(appUserDetails);
        log.info("[RegisterUser] IN DAO: {}",signUpRequest);
    }

    public Boolean checkIfUserExists(SignUpReq signUpRequest){
        return  appUserRepository.existsAppUserDetailsByName(signUpRequest.getUsername());
    }


}

