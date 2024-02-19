package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {
    @NotNull(message = "Имя пользователя не указано")
    private  String username;
    @NotEmpty(message = "Пароль не указан")
    private  String password;
    private  String fullname;
    @NotNull(message = "Электронная почта не указана")
    private  String emailAddress;

    private String cityName;
    private String streetName;
    private String buildingNumber;

    @Override
    public String toString() {
        return "UserRegistrationDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", cityName='" + cityName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                '}';
    }
}