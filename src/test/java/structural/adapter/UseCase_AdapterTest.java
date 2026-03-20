package structural.adapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UseCase_AdapterTest {
    @Mock
    OldPaymentSystem oldPaymentSystem;
    @InjectMocks
    PaymentAdapter paymentService;

    @Test
    public void should_convert_currency_using_adapter() {
        // Given
        doNothing().when(oldPaymentSystem).makePayment(anyString(), anyDouble());

        // When
        paymentService.process(123456, new BigDecimal(100));

        // Then
        verify(oldPaymentSystem).makePayment("123456", 100d);
    }
}
