package ru.sber.kapustin.homework6.library;

import org.springframework.stereotype.Component;
import ru.sber.kapustin.homework6.library.dao.BookDAOBean;
import ru.sber.kapustin.homework6.library.dao.UserDAOBean;
import ru.sber.kapustin.homework6.library.model.Book;

import java.sql.SQLException;

@Component
public class BooksSearcher {
    private UserDAOBean userDAOBean;
    private BookDAOBean bookDAOBean;

    private BooksSearcher(UserDAOBean userDAOBean, BookDAOBean bookDAOBean) {
        this.userDAOBean = userDAOBean;
        this.bookDAOBean = bookDAOBean;
    }

    public Book[] findUserBooksByEMail(String email) throws SQLException {
        var bookTitles = userDAOBean.findUserByEmail(email).getBooks();

        var books = new Book[bookTitles.length];
        for (var index = 0; index < bookTitles.length; index++) {
            books[index] = bookDAOBean.findBookByTitle(bookTitles[index]);
        }

        return books;
    }
}
