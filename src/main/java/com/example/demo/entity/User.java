package com.example.demo.entity;


import com.example.demo.enums.UserStatus;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private  String username;

    @Column(nullable = false)
    private  String password;
    private  String fullname;

    @Email
    private  String emailAddress;

    @Enumerated(value = EnumType.STRING)
    private UserStatus status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Role> roles = new ArrayList<>();

    public User(Long id) {
        this.id = id;
    }
}