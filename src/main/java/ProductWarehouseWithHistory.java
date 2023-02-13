package main.java;

/**
 * Product Warehouse with history
 * 
 * @author Brandon Nguyen (brandonnguyendev@gmail.com)
 * @version 2/12/2023
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory history;

    /**
     * Constructs a product warehouse with history list of balances
     * 
     * @param productName    the product name
     * @param capacity       how much this warehouse can hold
     * @param initialBalance the initial balance of this warehouse
     */
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        this.history = new ChangeHistory();
        this.history.add(initialBalance);
    }

    /**
     * Returns the string representation of the history list
     * 
     * @return the history list
     */
    public String history() {
        return this.history.toString();
    }

    /**
     * Prints out the details of this product warehouse
     */
    public void printAnalysis() {
        System.out.println("Product: " + this.getProductName());
        System.out.println("History: " + this.history());
        System.out.println("Largest amount of product: " + this.history.maxValue());
        System.out.println("Smallest amount of product: " + this.history.minValue());
        System.out.println("Average: " + this.history.average());
    }

    /**
     * Add amount to warehouse and record the new balance into history list
     * 
     * @param amount the desired amount to add into the warehouse
     */
    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.history.add(this.getBalance());
    }

    /**
     * Take a desired amount from the warehouse and record the new balance into
     * history list
     * 
     * @param amount the desired amount to take from the warehouse
     * @return the actual amount taken from the warehouse
     */
    @Override
    public double takeFromWarehouse(double amount) {
        double amountTaken = super.takeFromWarehouse(amount);
        this.history.add(this.getBalance());
        return amountTaken;
    }

    // printAnalysis() Test
    public static void main(String[] args) {
        ProductWarehouseWithHistory w = new ProductWarehouseWithHistory("Juice", 1000.0, 1000.0);
        w.takeFromWarehouse(11.3);
        w.addToWarehouse(1.0);
        w.printAnalysis();
    }

}
