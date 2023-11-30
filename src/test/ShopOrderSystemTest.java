package test;
import main.SystemOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class ShopOrderSystemTest {

    private SystemOrder shopOrderSystem;

    @BeforeEach
    public void setUp() {
        shopOrderSystem = new SystemOrder();
    }

    @Test
    public void testPayTheBill_WithNegativePayment() {

        String input = "-5.0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        SystemOrder shopOrderSystem = new SystemOrder();

        assertThrows(Exception.class, () -> shopOrderSystem.payTheBill());
    }

}

