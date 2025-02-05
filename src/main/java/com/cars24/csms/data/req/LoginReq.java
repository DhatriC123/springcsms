package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.NonNull;

@Data
public class LoginReq {
    @Valid
    @NonNull
    private String username;

    @Valid
    @NonNull
    private String password;
}
