package no.qvidahl.promillekalkulator;

import java.util.Date;

/**
 * Created by Thomas Qvidahl on 24.01.2017.
 */

public class UnitOfAlcohol {

    private String name; // Feks "Juleøl", "Rødvin"
    private double alcoholAmount; // Alkoholmengde i gram
    private double unitSize; // Væskemengde i cl
    private double strength; // Alkoholprosent
    private Date consumed; // Tidspunkt for inntak

    public UnitOfAlcohol() {
        // Constructor for klassen. Lager en tom enhet.
        this.name = "";
        this.alcoholAmount = 0.0;
        this.unitSize = 0.0;
        this.strength = 0.0;
    }

    public UnitOfAlcohol(String name, double alcoholAmount, double unitSize, double strength) {
        this.name = name;
        this.alcoholAmount = alcoholAmount;
        this.unitSize = unitSize;
        this.strength = strength;
    }

    public static void remainingAlcohol(Date timestamp) {

        // TODO Beregn gjenstående alkoholmengde i gram for denne enheten.

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAlcoholAmount() {
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

}
