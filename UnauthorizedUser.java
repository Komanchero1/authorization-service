package org.example.authorization_service.exception;

//класс является наследником RuntimeException, используется
// для присечения доступа не авторизованных пользователей
// и настройки сообщения используемого в исключении
public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg) {
        super(msg);
    }
}

