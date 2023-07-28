package ru.sber.kapustin.homework6.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static ru.sber.kapustin.homework6.library.constants.DBConstants.*;

@Configuration
public class MyDBConfigContext {
    @Bean
    @Scope("singleton")
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://" + DB_HOST + ":" + PORT + "/" +
                DB, USER, PASSWORD);
    }
}

