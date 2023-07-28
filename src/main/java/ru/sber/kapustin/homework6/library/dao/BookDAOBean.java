package ru.sber.kapustin.homework6.library.dao;

import org.springframework.stereotype.Component;
import ru.sber.kapustin.homework6.library.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookDAOBean {
    private final Connection connection;

    private final String SELECT_BOOK_BY_ID_QUERY = "select * from books where id = ?";
    private final String SELECT_BOOK_BY_TITLE_QUERY = "select * from books where title = ?";

    public BookDAOBean(Connection connection) {
        this.connection = connection;
    }

    public Book findBookById(Integer bookId) throws SQLException {
        PreparedStatement selectQuery = connection.prepareStatement(SELECT_BOOK_BY_ID_QUERY);
        selectQuery.setInt(1, bookId);

        return convertToBook(selectQuery.executeQuery());
    }

    public Book findBookByTitle(String title) throws SQLException {
        var statement = connection.prepareStatement(SELECT_BOOK_BY_TITLE_QUERY);
        statement.setString(1, title);

        return convertToBook(statement.executeQuery());
    }

    private Book convertToBook(ResultSet resultSet) throws SQLException {
        var book = new Book();
        while (resultSet.next()) {
            book.setId(resultSet.getInt("id"));
            book.setAuthor(resultSet.getString("author"));
            book.setTitle(resultSet.getString("title"));
            book.setDateAdded(resultSet.getDate("date_added"));
        }

        return book;
    }
}

