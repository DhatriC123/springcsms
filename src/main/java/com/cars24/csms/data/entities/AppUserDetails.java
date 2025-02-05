package com.cars24.csms.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Data
@Entity
@Table(name = "user_details")
public class AppUserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @jakarta.persistence.Column(name="user_id")
    @NonNull
    private Integer id;

    @jakarta.persistence.Column(name="user_name")
    private String name;

    @jakarta.persistence.Column(name="user_password")
    private String password;

    @jakarta.persistence.Column(name="Active")
    Boolean Isactive;



}
