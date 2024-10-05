package org.example.authorization_service.model;

import javax.validation.constraints.NotEmpty;

public class User {


    //аннотация @NotEmpty указывает что данный элемент не может быть пустым в случае если пустой
    // пользователю отправится сообщение в скобках
    @NotEmpty(message = "имя не указано")
    private String user;

    //аннотация @NotEmpty указывает что данный элемент не может быть пустым в случае если пустой
    // пользователю отправится сообщение в скобках
    @NotEmpty(message = "пароль не указан")
    private String password;

    // геттеры и сеттеры
    public String getUser() {
        return user;
    }

    public void setUser(String user) {

        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }
}
