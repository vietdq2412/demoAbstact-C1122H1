package org.example;

import java.time.LocalDate;

public class Meat extends Material implements Discount{
    private double weight;

    public Meat() {
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return cost * weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return manufacturingDate.plusDays(7);
    }

    @Override
    public double getRealMoney() {
        LocalDate expiryDate = this.getExpiryDate();
        LocalDate now = LocalDate.now();
        if (expiryDate.minusDays(2).isBefore(now)){
            return this.getCost() * 0.7;
        }else {
            return this.getCost() *  0.9;
        }
    }
}
