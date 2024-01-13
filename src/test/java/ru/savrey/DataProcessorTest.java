package ru.savrey;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
/**
 * У вас есть класс Database с методом public List<String> query(String sql), который выполняет SQL-
 * запрос и возвращает результат.
 * Вам необходимо проверить правильность работы класса DataProcessor,
 * который использует Database для выполнения запроса и обработки результатов.
 */
public class DataProcessorTest {
    @Test
    public void dataProcessorSQLRequest() {
        Database databaseMock = mock(Database.class);
        List<String> fakeData = new ArrayList<>();
        fakeData.add("data1");
        fakeData.add("data2");
        fakeData.add("data3");
        when(databaseMock.query("sql")).thenReturn(fakeData);

        DataProcessor dataProcessor = new DataProcessor(databaseMock);

        assertEquals(fakeData, dataProcessor.processData("sql"));
    }
}
