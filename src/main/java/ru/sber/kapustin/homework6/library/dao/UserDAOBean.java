package ru.sber.kapustin.homework6.library.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.sber.kapustin.homework6.library.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

@Component
@Scope(scopeName = "prototype")
public class UserDAOBean {
    private final Connection connection;

    private final String ADD_USER = "insert into users(first_name, last_name, birthdate, phone, email, books) values (?, ?, ?, ?, ?, ?)";
    private final String SELECT_USER_BY_EMAIL_QUERY = "select * from users where email = ?";

    public UserDAOBean(Connection connection) {
        this.connection = connection;
    }

    public void addUser(String firstName, String lastName, Date birthdate, String phone, String email, String[] books) throws SQLException {
        var statement = connection.prepareStatement(ADD_USER);
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setDate(3, new java.sql.Date(birthdate.getTime()));
        statement.setString(4, phone);
        statement.setString(5, email);
        statement.setArray(6, statement.getConnection().createArrayOf("text", books));
        statement.executeUpdate();
    }

    public User findUserByEmail(String email) throws SQLException {
        var statement = connection.prepareStatement(SELECT_USER_BY_EMAIL_QUERY);
        statement.setString(1, email);

        var res = statement.executeQuery();
        var user = new User();
        while (res.next()) {
            user.setFirstName(res.getString("first_name"));
            user.setLastName(res.getString("last_name"));
            user.setBirthday(res.getDate("birthday"));
            user.setPhone(res.getString("phone"));
            user.setEmail(res.getString("email"));
            user.setBooks(new String[]{res.getString("books")});
        }

        return user;
    }
}
