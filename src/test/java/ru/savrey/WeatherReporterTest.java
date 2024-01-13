package ru.savrey;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WeatherReporterTest {
    @Test
    public void weatherReporterGetTemperature() {
        WeatherService weatherServiceMock = mock(WeatherService.class);
        when(weatherServiceMock.getCurrentTemperature()).thenReturn(25);

        WeatherReporter weatherReporter = new WeatherReporter(weatherServiceMock);

        assertEquals("Текущая температура: 25 градусов.", weatherReporter.generateReport());
    }
}
