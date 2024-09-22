package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class Util {
    public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String USER = "postgres";
    public static final String PASSWORD = "postgres";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Соединение установлено");
        } catch (SQLException e) {
            System.out.println("При подключении к базе данных произошла ошибка");
            e.printStackTrace();
        }
        return connection;
    }
public class HiberUtil {
        private static final SessionFactory sessionFactory = buildSessionFactory();

        private static SessionFactory buildSessionFactory() {
            try {
                Configuration configuration = new Configuration();
                configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
                configuration.setProperty("hibernate.driver_class", "org.postgresql.Driver");
                configuration.setProperty("hibernate.connection.url", URL);
                configuration.setProperty("hibernate.connection.username", USER);
                configuration.setProperty("hibernate.connection.password", PASSWORD);

//                configuration.setProperty("hibernate.show_sql", "true");
                configuration.setProperty("hibernate.hbm2ddl.auto", "create");
//                configuration.setProperty("hibernate.format_sql", "true");

                configuration.addAnnotatedClass(User.class);

                StandardServiceRegistry ServiceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                return configuration.buildSessionFactory(ServiceRegistry);
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        public static SessionFactory getSessionFactory() {
            return sessionFactory;

        }
        public static Session getSession() {return getSessionFactory().openSession();}
}

}
