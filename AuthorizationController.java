package org.example.authorization_service.controller;


import org.example.authorization_service.model.User;
import org.example.authorization_service.servise.Authorities;
import org.example.authorization_service.servise.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//аннотация указывает, что класс является контроллером и его методы возвращают данные
// в формате JSON или XML
@RestController
public class AuthorizationController {//класс для обработки запросов авторизации

    //аннотация указывает Spring контейнеру автоматически внедрить экземпляр
    // AuthorizationService в поле service
    @Autowired
    private AuthorizationService service;

    //аннотация указывает, что метод, к которому она применена, будет обрабатывать HTTP GET запросы
    //метод будет срабатывать, когда клиент отправляет GET запрос по адресу /authorize
    @GetMapping("/authorize")
    //аннотация @RequestParam позволяет извлекать нужные строки из запроса
    //аннотация @Valid позволяет автоматически проверять поле user и password на валидность
    public List<Authorities> getAuthoritiesGet(@Valid @RequestParam String user, @Valid @RequestParam String password) {
        User userObj = new User();//создается экземпляр класса User
        userObj.setUser(user);//добавляется в объект имя пользователя
        userObj.setPassword(password);//добавляется в объект пароль пользователя

        return service.getAuthorities(userObj);//возвращает пользователю список допусков в формате JSON
    }

    //аннотация указывает, что метод, к которому она применена, будет обрабатывать HTTP POST запросы
    //метод будет срабатывать, когда клиент отправляет POST запрос по адресу /authorize
    @PostMapping("/authorize")
    //аннотация @Valid позволяет проверять объект User на валидность ,аннотация указывает,
    // что данные должны быть извлечены из тела HTTP-запроса и автоматически десериализованы
    // в объект User
    public List<Authorities> getAuthorities(@Valid @RequestBody User user) {
        //возвращает пользователю список допусков в формате  JSON
        return service.getAuthorities(user);
    }
}

