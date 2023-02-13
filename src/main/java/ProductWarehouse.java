package main.java;

/**
 * Product-specific Warehouse Class
 */
public class ProductWarehouse extends Warehouse {

    private String productName;

    /**
     * Construct a product-specific warehouse
     * 
     * @param productName the name of the product
     * @param capacity    how much this warehouse can hold
     */
    public ProductWarehouse(String productName, double capacity) {
        super(capacity);
        this.productName = productName;
    }

    /**
     * Get the product's name
     * 
     * @return the product's name
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * Set the product's name to a new name
     * 
     * @param name a new name for the product
     */
    public void setProductName(String name) {
        this.productName = name;
    }

    /**
     * Returns the string representation for the product-specific warehouse
     * 
     * @return the string representation for the product-specific warehouse (e.g.
     *         'Juice: balance = 64.5, space left 123.5')
     */
    @Override
    public String toString() {
        return this.productName + ": " + super.toString();
    }

}
