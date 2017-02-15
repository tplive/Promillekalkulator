package no.qvidahl.promillekalkulator;

import java.util.Date;

/**
 * Created by Thomas Qvidahl on 24.01.2017.
 */

class UnitOfAlcohol {

    /**
     *
     */
    private String name; // Feks "Beer", "Wine"
    private double alcoholAmount; // Alkoholmengde i gram
    private double unitSize; // Væskemengde i cl
    private double strength; // Alkoholprosent
    private int consumedNumber; // Antall konsumert

    public UnitOfAlcohol() {
        // Constructor for klassen. Lager en tom enhet.
        this.name = "";
        this.alcoholAmount = 0.0;
        this.unitSize = 0.0;
        this.strength = 0.0;
        this.consumedNumber = 0;
    }

    UnitOfAlcohol(String name, double alcoholAmount, double unitSize, double strength) {
        this.name = name;
        this.alcoholAmount = alcoholAmount;
        this.unitSize = unitSize;
        this.strength = strength;
        this.consumedNumber = 0;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    double getAlcoholAmount() {
        return this.alcoholAmount;
    }

    public void setAlcoholAmount(double alcoholAmount) {
        this.alcoholAmount = alcoholAmount;
    }

    public double getUnitSize() {
        return this.unitSize;
    }

    public void setUnitSize(double fluidAmount) {
        this.unitSize = fluidAmount;
    }

    public double getStrength() {
        return this.strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public int getConsumedNumber() {
        return this.consumedNumber;
    }
    public void consumeOne() {
        this.consumedNumber++;
    }
    public void resetConsumed() {
        this.consumedNumber = 0;
    }
}
