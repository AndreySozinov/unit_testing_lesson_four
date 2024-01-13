package ru.savrey;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
/**
 * У вас есть класс MessageService с методом public void sendMessage(String message, String
 * recipient), который отправляет сообщение получателю.
 * Вам необходимо проверить правильность работы класса NotificationService, который использует
 * MessageService для отправки уведомлений.
 */
public class NotificationServiceTest {
    @Test
    public void sendingMessageTest() {
        MessageService messageServiceMock = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageServiceMock);

        notificationService.sendNotification("Hello", "Peter");

        verify(messageServiceMock, times(1)).sendMessage("Hello", "Peter");

    }
}
