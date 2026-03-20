package structural.adapter;

import java.math.BigDecimal;

public interface PaymentService {
    void process(Integer cardNumber, BigDecimal amount);
}
