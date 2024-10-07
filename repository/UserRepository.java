package org.example.authorization_service.repository;
import org.example.authorization_service.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

//аннотация @Repository помечает класс как репозиторий
@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        // задаем и проверяем соответствие данных для примера1
        if ("user1".equals(user) && "pass1".equals(password)) {
            //создается и возвращается список доступов для первого примера
            return Arrays.asList(Authorities.READ, Authorities.WRITE);
            // задаем и проверяем соответствие данных для примера2
        } else if ("user2".equals(user) && "pass2".equals(password)) {
            return Arrays.asList(Authorities.READ,Authorities.DELETE);
        }
        return List.of(); // Возвращаем пустой список, если пользователь не найден
    }
}