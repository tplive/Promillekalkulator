package no.qvidahl.propromille;

import java.util.Date;

/**
 * Created by Thomas Qvidahl on 25.01.2017.
 */

public class BloodAlcoholLevel {

    private float bloodAlcoholLevel;
    private Date now;
    private UnitOfAlcohol units;

    public float getBloodAlcoholLevel() {
        // TODO Beregn promillenivå nå, basert på kjønn, vekt og tid, samt antall gram alkohol inntatt og som gjenstår.
        return this.bloodAlcoholLevel;
    }
}
