package org.example.authorization_service.controller;

import org.example.authorization_service.servise.Authorities;
import org.example.authorization_service.servise.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//аннотация указывает, что класс является контроллером и его методы возвращают данные
// в формате JSON или XML
@RestController
//класс для обработки запросов авторизации
public class AuthorizationController {

    //аннотация указывает Spring контейнеру автоматически внедрить экземпляр
    // AuthorizationService в поле service
    @Autowired
    private AuthorizationService service;

    //аннотация связывает HTTP GET запрос на /authorize с методом getAuthorities.
    @GetMapping("/authorize")
    //аннотация @RequestParam позволяет извлекать нужные строки из запроса
    public List<Authorities> getAuthorities(@RequestParam String user, @RequestParam String password) {
        //возвращает пользователю список допусков в формате  JSON
        return service.getAuthorities(user, password);
    }
}
