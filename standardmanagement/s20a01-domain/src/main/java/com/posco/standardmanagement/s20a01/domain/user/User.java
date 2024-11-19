package com.posco.standardmanagement.s20a01.domain.user;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "User_table")
@Data
public class User {

    @Id
    private String username;

    @Enumerated(EnumType.STRING)
    private Email email;

    private String phoneNumber;
}
