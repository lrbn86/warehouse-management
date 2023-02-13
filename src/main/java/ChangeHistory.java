package main.java;

import java.util.ArrayList;

/**
 * ChangeHistory Class
 * Manages how the inventory of a product changes over time
 * 
 * @author Brandon Nguyen (brandonnguyendev@gmail.com)
 * @version 2/12/2023
 */
public class ChangeHistory {

    ArrayList<Double> history;

    /**
     * Constructs a history manager for a warehouse
     */
    public ChangeHistory() {
        this.history = new ArrayList<Double>();
    }

    /**
     * Add status to history
     * 
     * @param status the latest amount to remember
     */
    public void add(double status) {
        this.history.add(status);
    }

    /**
     * Clears the history of the warehouse
     */
    public void clear() {
        this.history.clear();
    }

    /**
     * Returns the string representation of the warehouse's history
     * 
     * @return the warehouse's history
     */
    public String toString() {
        return history.toString();
    }

    /**
     * Returns the largest value in the change history
     * 
     * @return the largest value in the change history
     */
    public double maxValue() {
        double max = this.history.get(0);
        for (double value : this.history) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Returns the smallest value in the change history. If the history is empty,
     * return 0.
     * 
     * @return the smallest value in the change history or 0
     */
    public double minValue() {
        if (this.history.isEmpty()) {
            return 0;
        }
        double min = this.history.get(0);
        for (double value : this.history) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    /**
     * Returns the average of the change history
     * 
     * @return the average of the change history
     */
    public double average() {
        double sum = 0.0;
        for (double value : this.history) {
            sum += value;
        }
        double avg = sum / this.history.size();
        double rounded = (double) Math.round(avg * 10) / 10;
        return rounded;
    }

}
