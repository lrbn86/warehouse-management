package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.Warehouse;

/**
 * Warehouse Test Class
 * 
 * @author Brandon Nguyen (brandonnguyendev@gmail.com)
 * @version 2/12/2023
 */
public class WarehouseTest {

    Warehouse w;
    Warehouse juice;

    @BeforeEach
    public void setUp() {
        w = new Warehouse(200);
        juice = new Warehouse(1000.0);
    }

    @Test
    public void testTakeMoreThanCapacity() {
        w.addToWarehouse(100);
        double amountTaken = w.takeFromWarehouse(500);
        assertEquals(100, amountTaken);
        assertEquals(0, w.getBalance());
    }

    @Test
    public void testTakeAtCurrentBalance() {
        w.addToWarehouse(100);
        assertEquals(100, w.takeFromWarehouse(100));
        assertEquals(0, w.getBalance());
    }

    @Test
    public void testTakeNegativeAmount() {
        w.addToWarehouse(100);
        double amountTaken = w.takeFromWarehouse(-100);
        assertEquals(100, w.getBalance());
        assertEquals(0, amountTaken);
    }

    @Test
    public void testAddNegativeAmount() {
        w.addToWarehouse(100);
        w.addToWarehouse(-100);
        assertEquals(100, w.getBalance());
    }

    @Test
    public void testStringRepresentation() {
        juice.addToWarehouse(1000);
        juice.takeFromWarehouse(11.3);
        assertEquals("balance = 988.7, space left 11.3", juice.toString());
    }

}
