package ru.savrey;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Вам нужно написать тест с использованием моков для класса, который выполняет HTTP-запросы.
 * Условие: У вас есть класс HttpClient с методом public String get(String url), который выполняет
 * HTTP-запрос и возвращает результат. Вам необходимо проверить правильность работы класса
 * WebService, который использует HttpClient для получения данных с веб-сайта.
 */

public class WebServiceTest {
    @Test
    public void webServiceAnswering() {
        HttpClient httpClientMock = mock(HttpClient.class);
        when(httpClientMock.get(anyString())).thenReturn("Site site.ru answer");

        WebService webService = new WebService(httpClientMock);

        assertEquals("Site site.ru answer", webService.getInfoFromSite("123"));
    }
}
