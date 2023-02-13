package main.java;

/**
 * Warehouse Class
 * 
 * @author Brandon Nguyen (brandonnguyendev@gmail.com)
 * @version 2/12/2023
 */
public class Warehouse {

    private double capacity;
    private double balance;

    /**
     * Construct a warehouse with a desired capacity. A useless warehouse will be
     * created if negative capacity is given.
     * 
     * @param capacity how much this warehouse can hold
     */
    public Warehouse(double capacity) {
        if (capacity <= 0) {
            this.capacity = 0;
            return;
        }
        this.capacity = capacity;
    }

    /**
     * Return the warehouse's balance
     * 
     * @return the warehouse's current balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Return the warehouse's capacity
     * 
     * @return the warehouse's current capacity
     */
    public double getCapacity() {
        return this.capacity;
    }

    /**
     * Return how much space is left in the warehouse
     * 
     * @return the remaining space left in the warehouse
     */
    public double howMuchSpaceLeft() {
        return this.capacity - this.balance;
    }

    /**
     * Add a desired amount into the warehouse
     * 
     * @param amount the desired amount to add into the warehouse
     */
    public void addToWarehouse(double amount) {
        if (amount <= 0) {
            return;
        }
        if (amount >= this.howMuchSpaceLeft() || amount >= this.capacity) {
            this.balance = this.capacity;
            return;
        }
        this.balance += amount;
    }

    /**
     * Return the actual amount taken from the warehouse
     * 
     * @param amount the desired amount to take from the warehouse
     * @return the actual amount that is taken from the warehouse
     */
    public double takeFromWarehouse(double amount) {
        if (amount <= 0) {
            return 0;
        }
        if (amount >= this.balance || amount >= this.capacity) {
            amount = this.balance;
            this.balance = 0;
            return amount;
        }
        this.balance -= amount;
        return amount;
    }

    /**
     * Return the string representation of the warehouse
     * 
     * @return the string representation of warehouse (e.g. 'balance = 64.5, space
     *         left 123.5')
     */
    public String toString() {
        double rounded = (double) Math.round(this.howMuchSpaceLeft() * 10) / 10; // Rounded to one decimal place
        return "balance = " + this.balance + ", space left " + rounded;
    }

}
