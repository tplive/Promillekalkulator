package no.qvidahl.promillekalkulator;

/**
 * Created by Thomas Qvidahl on 24.01.2017.
 */

public class UnitOfAlcohol {

    private String name; // Feks "Juleøl", "Rødvin"
    private float alcoholAmount; // Alkoholmengde i gram
    private float unitSize; // Væskemengde i cl
    private float strength; // Alkoholprosent

    public static UnitOfAlcohol() {
        // Constructor for klassen. Lager en tom enhet.
        this.name = "";
        this.alcoholAmount = 0.0;
        this.unitSize = 0.0;
        this.strength = 0.0;
    }

    public static UnitOfAlcohol(String name, float alcoholAmount, float unitSize, float strength) {
        this.name = name;
        this.alcoholAmount = alcoholAmount;
        this.unitSize = unitSize;
        this.strength = strength;
    }

    public static String getName() {
        return this.name;
    }

    public static void setName(String name) {
        this.name = name;
    }

    public static float getAlcoholAmount() {
        return this.alcoholAmount;
    }

    public static void setAlcoholAmount(float alcoholAmount) {
        this.alcoholAmount = alcoholAmount;
    }

    public static float getUnitSize() {
        return this.unitSize;
    }

    public static void setUnitSize(float fluidAmount) {
        this.unitSize = fluidAmount;
    }

    public static float getStrength() {
        return this.strength;
    }

    public static void setStrength(float strength) {
        this.strength = strength;
    }

}
