package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.ProductWarehouse;

/**
 * Product Warehouse Class
 * 
 * @author Brandon Nguyen (brandonnguyendev@gmail.com)
 * @version 2/12/2023
 */
public class ProductWarehouseTest {

    ProductWarehouse w;

    @BeforeEach
    public void setUp() {
        w = new ProductWarehouse("Juice", 1000.0);
    }

    @Test
    public void testAddThousand() {
        w.addToWarehouse(1000);
        assertEquals(1000.0, w.getBalance());
    }

    @Test
    public void testTakeFromWarehouse() {
        w.addToWarehouse(1000);
        w.takeFromWarehouse(11.3);
        assertEquals(988.7, w.getBalance());
    }

    @Test
    public void testGetProductName() {
        assertEquals("Juice", w.getProductName());
    }

    @Test
    public void testStringRepresentation() {
        w.addToWarehouse(1000);
        w.takeFromWarehouse(11.3);
        w.addToWarehouse(1.0);
        assertEquals("Juice: balance = 989.7, space left 10.3", w.toString());
    }

}
