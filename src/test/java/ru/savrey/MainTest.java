package ru.savrey;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

import org.mockito.*;
import static org.mockito.Mockito.*;

public class MainTest {
    public static void main(String[] args) {
        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(0)).thenReturn("nullValue");
        when(mockedList.get(1)).thenThrow(new RuntimeException());
        //mockedList.add("one");
        //mockedList.clear();

        verify(mockedList).get(0);
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, never()).add("never happened");

        verify(mockedList, timeout(100));
    }

    @Mock
    private Calendar calendar;

    /**
     * 4.1. Создать мок-объект Iterator, настроить поведение так,
     * чтобы за два вызова next() Iterator вернул два слова  “Hello World”,
     * и проверить это поведение с помощью утверждений
     */
    @Test
    public void iteratorWillReturnHelloWorld() {
        // Arrange
        Iterator iteratorMock = mock(Iterator.class);
        when(iteratorMock.next()).thenReturn("Hello", "World");
        // Act
        String result = iteratorMock.next() + " " + iteratorMock.next();
        // Assert
        assertEquals("Hello World", result);
    }


}
