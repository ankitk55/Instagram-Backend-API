package com.Ankit.InstagramBackendBasicDesign.model;

import com.Ankit.InstagramBackendBasicDesign.model.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "userData")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userFirstName;
    private String userLastName;
    private Integer userAge;

    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.com$")
    private  String userEmail;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String userPassword;
    @Pattern(regexp = "\\d{10}")
    private String userPhoneNumber;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int follower=0;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int following=0;

    private AccountType accountType;

}
