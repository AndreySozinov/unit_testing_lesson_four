package ru.savrey.homework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * У вас есть класс BookService, который использует интерфейс BookRepository для получения
 * информации о книгах из базы данных. Ваша задача написать unit-тесты для BookService, используя
 * Mockito для создания мок-объекта BookRepository.
 */

public class BookServiceTest {
    @Test
    void findBookByIdTest() {
        BookRepository bookRepositoryMock = mock(BookRepository.class);
        Book book = new Book("1", "Book1", "Author1");
        when(bookRepositoryMock.findById(anyString())).thenReturn(book);

        BookService bookService = new BookService(bookRepositoryMock);
        Book wantedBook = bookService.findBookById("1");

        assertEquals(book, wantedBook);
    }

    @Test
    void findAllBookTest() {
        BookRepository bookRepositoryMock = mock(BookRepository.class);
        List<Book> books = new ArrayList<>();
        books.add(new Book("1", "Book1", "Author1"));
        books.add(new Book("2", "Book2", "Author2"));
        books.add(new Book("3", "Book3", "Author3"));
        when(bookRepositoryMock.findAll()).thenReturn(books);

        BookService bookService = new BookService(bookRepositoryMock);
        List<Book> wantedBookList = bookService.findAllBooks();

        assertEquals(books, wantedBookList);
    }
}
