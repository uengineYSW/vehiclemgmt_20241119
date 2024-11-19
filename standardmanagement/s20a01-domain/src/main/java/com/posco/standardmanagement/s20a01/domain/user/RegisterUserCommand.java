package com.posco.standardmanagement.s20a01.domain.user;

import com.posco.standardmanagement.s20a01.domain.Email;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RegisterUserCommand {

    private String username;
    private Email email;
    private String phoneNumber;
}
