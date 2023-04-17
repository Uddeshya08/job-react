package com.smoney.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data
public class UserRequest {

    @NotNull(message = "Please provide username while registrating")
    private String username;

    @NotNull(message = "Please provide first name while registrating")
    private String firstName;

    private String lastName;



    @NotNull(message = "Please provide password while registrating")
    private String password;

    @Email
    private String email;


    @NotNull(message = "Please provide valid mobile no while registrating")
    @Pattern(regexp = "^\\d{10}$")
    private String mobileNo;

    private String roles;

    private String location;

    private String skills;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
