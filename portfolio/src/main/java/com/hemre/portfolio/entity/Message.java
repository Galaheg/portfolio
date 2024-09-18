package com.hemre.portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "message")
@Data
public class Message {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "message")
    private String message;

    public Message() {
    }

    public Message(String fullName, String email, String phoneNumber, String message) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.message = message;
    }
}
