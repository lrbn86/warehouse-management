package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.ProductWarehouseWithHistory;

/**
 * ProductWarehouseWithHistoryTest Class
 * 
 * @author Brandon Nguyen (brandonnguyendev@gmail.com)
 * @version 2/12/2023
 */
public class ProductWarehouseWithHistoryTest {

    ProductWarehouseWithHistory w;

    @BeforeEach
    public void setUp() {
        w = new ProductWarehouseWithHistory("Juice", 1000.0, 1000.0);
    }

    @Test
    public void testStringRepresentation() {
        w.takeFromWarehouse(11.3);
        w.addToWarehouse(1.0);
        assertEquals("Juice: balance = 989.7, space left 10.3", w.toString());
    }

    @Test
    public void testChangeHistory() {
        w.takeFromWarehouse(11.3);
        w.addToWarehouse(1.0);
        assertEquals("[1000.0, 988.7, 989.7]", w.history());
    }

}
