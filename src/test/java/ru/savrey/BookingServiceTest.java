package ru.savrey;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
/**
 * У вас есть класс HotelService с методом public boolean isRoomAvailable(int roomId),
 * который обычно проверяет, доступен ли номер в отеле.
 * Вам необходимо проверить правильность работы класса BookingService, который
 * использует HotelService для бронирования номера, если он доступен.
 */

public class BookingServiceTest {
    @Test
    public void BookingHotelNumber() {
        HotelService hotelServiceMock = mock(HotelService.class);
        when(hotelServiceMock.isRoomAvailable(202)).thenReturn(true);
        when(hotelServiceMock.isRoomAvailable(201)).thenReturn(false);

        BookingService bookingService = new BookingService(hotelServiceMock);

        assertTrue(bookingService.bookRoom(202));
        assertFalse(bookingService.bookRoom(201));
    }
}
