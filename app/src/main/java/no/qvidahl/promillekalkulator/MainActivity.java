package no.qvidahl.promillekalkulator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView mPromilleTextView;
    private boolean isMan = true;
    private double consumedAlcohol = 0.0;
    private double weight = 80;
    private int hoursPassed = 3;

    private Button btnBeer;
    private Button btnWine;
    private Button btnSpirit;
    private ToggleButton btnSexChange; //https://developer.android.com/guide/topics/ui/controls/togglebutton.html
    private SeekBar seekBar;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mClient;


    protected String promilleTekst(double promille) {

        DecimalFormat mNumberFormat = new DecimalFormat("#.##");
        String formatted = mNumberFormat.format(promille);
        return String.format("%s ‰", formatted);

    }

    protected double calculateBloodAlcoholLevel(double weight, boolean isMan, double consumedAmount, double hoursSinceStart) {

        double bloodAlcoholLevel;
        // Alkoholen fordeler seg i 70% av menns kroppsvekt, 60% av kvinners
        if (isMan) {
            weight = weight * 0.7;
        } else {
            weight = weight * 0.6;
        }
        // Promillen er antall gram alkohol inntatt delt på kjønnsjustert vekt - 0,15 gram pr time
        bloodAlcoholLevel = consumedAmount / weight - (0.15 * hoursSinceStart);

        if (bloodAlcoholLevel <= 0) {
            bloodAlcoholLevel = 0;
        }

        return bloodAlcoholLevel;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final UnitOfAlcohol beer = new UnitOfAlcohol("Beer", 15, 33, 4.5);
        final UnitOfAlcohol wine = new UnitOfAlcohol("Wine", 15, 25, 14);
        final UnitOfAlcohol spirit = new UnitOfAlcohol("Spirit", 15, 4, 40);

        mPromilleTextView = (TextView) findViewById(R.id.promilleVerdi);
        mPromilleTextView.setText(promilleTekst(3.4567));

        btnBeer = (Button) findViewById(R.id.btnBeer);
        btnBeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consumedAlcohol = consumedAlcohol + beer.getAlcoholAmount();
                mPromilleTextView.setText(promilleTekst(calculateBloodAlcoholLevel(weight, isMan, consumedAlcohol, hoursPassed)));
            }
        });
        btnWine = (Button) findViewById(R.id.btnWine);
        btnWine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consumedAlcohol = consumedAlcohol + wine.getAlcoholAmount();
                mPromilleTextView.setText(promilleTekst(calculateBloodAlcoholLevel(weight, isMan, consumedAlcohol, hoursPassed)));
            }
        });

        btnSpirit = (Button) findViewById(R.id.btnSpirit);
        btnSpirit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consumedAlcohol = consumedAlcohol + spirit.getAlcoholAmount();
                mPromilleTextView.setText(promilleTekst(calculateBloodAlcoholLevel(weight, isMan, consumedAlcohol, hoursPassed)));
            }
        });

        btnSexChange = (ToggleButton) findViewById(R.id.toggleSex);
        btnSexChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isMan = true;
                    Log.i(TAG, "Satt til Mann");
                } else {
                    isMan = false;
                    Log.i(TAG, "Satt til Kvinne");
                }
                mPromilleTextView.setText(promilleTekst(calculateBloodAlcoholLevel(weight, isMan, consumedAlcohol, hoursPassed)));
            }
        });

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                hoursPassed = seekBar.getProgress();
            }
        }
    }
        );

}
