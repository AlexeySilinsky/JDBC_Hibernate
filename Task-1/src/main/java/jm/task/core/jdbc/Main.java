package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Уолтер", "Уайт", (byte) 50);
        System.out.println("User с именем " + userService.getAllUsers().get(0).getName() + " добавлен в базу данных");
        userService.saveUser("Джесси", "Пинкман", (byte) 24);
        System.out.println("User с именем " + userService.getAllUsers().get(1).getName() + " добавлен в базу данных");
        userService.saveUser("Скайлер","Уайт", (byte) 38);
        System.out.println("User с именем " + userService.getAllUsers().get(2).getName() + " добавлен в базу данных");
        userService.saveUser("Хэнк", "Шрейдер", (byte) 42);
        System.out.println("User с именем " + userService.getAllUsers().get(3).getName() + " добавлен в базу данных");

        userService.getAllUsers().forEach(System.out::println);
        System.out.println("Все пользователи выведены в консоль");

        userService.cleanUsersTable();
        System.out.println("Строки очищены");

        userService.dropUsersTable();
        System.out.println("Таблица удалена");
    }
}
