package com.pasanabeysekara.securitywithswagger.dto;

import com.pasanabeysekara.securitywithswagger.enums.Gender;
import com.pasanabeysekara.securitywithswagger.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String address;
    private String mobileNumber;
    private Gender gender;
    private Role role;
}
