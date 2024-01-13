package ru.savrey;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class PaymentFormTest {
    /**
     * 4.2. Используя библиотеку Mockito, напишите модульные тесты для проверки функциональности формы оплаты на сайте.
     * * Вместо реальной кредитной карты используйте мок-объект.
     * Создайте класс `CreditCard` с методами `getCardNumber()`, `getCardHolder()`, `getExpiryDate()`, `getCvv()`, `charge(double amount)`.
     * Создайте класс `PaymentForm` с методом `pay(double amount)`.
     * В тестовом классе, создайте мок-объект для класса `CreditCard`.
     * Определите поведение мок-объекта с помощью метода `when()`.
     * Создайте объект класса `PaymentForm`, передайте ему мок-объект в качестве аргумента.
     * Вызовите метод `pay()` и убедитесь, что мок-объект вызывает метод `charge()`
     */
    @Test
    public void paymentWorks() {
        CreditCard creditCardMock = mock(CreditCard.class);

        PaymentForm paymentForm = new PaymentForm(creditCardMock);
        double amount = 50d;
        paymentForm.pay(amount);

        verify(creditCardMock, times(1)).charge(amount);
    }
}
