package no.qvidahl.promillekalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView mPromilleTextView;
    private boolean isMan = true;
    private double remainingAlcohol = 0.0;

    private Button btnBeer;
    private Button btnWine;
    private Button btnSpirit;
    private ToggleButton btnSexChange; //https://developer.android.com/guide/topics/ui/controls/togglebutton.html

    DecimalFormat mNumberFormat = new DecimalFormat("#.##");
    final double promille = Math.random();
    final String promilleTekst = String.valueOf(mNumberFormat.format(promille));

    protected double calculateBloodAlcoholLevel(double weight, boolean isMan, double remainingAmount, double secondsSinceStart) {

        double bloodAlcoholLevel;
        // Alkoholen fordeler seg i 70% av menns kroppsvekt, 60% av kvinners
        if (isMan) {
            weight = weight * 0.7;
        }else {
            weight = weight * 0.6;
        }

        bloodAlcoholLevel = remainingAmount / weight - (0.15 * 3600 * secondsSinceStart);

        if (bloodAlcoholLevel <= 0) {
            bloodAlcoholLevel = 0;
        }

        return bloodAlcoholLevel;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        UnitOfAlcohol beer = new UnitOfAlcohol("Beer", 15, 33, 4.5);
        UnitOfAlcohol wine = new UnitOfAlcohol("Wine", 15, 25, 14);
        UnitOfAlcohol spirit = new UnitOfAlcohol("Spirit", 15, 4, 40);

        mPromilleTextView = (TextView)findViewById(R.id.promilleVerdi);
        mPromilleTextView.setText(String.format("%s ‰", promilleTekst));

        btnBeer = (Button)findViewById(R.id.btnBeer);
        btnBeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Legg til alkoholen fra en øl til promilleberegningen.
                // Beregn promillen på nytt.
            }
        });
        btnWine = (Button)findViewById(R.id.btnWine);
        btnWine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Legg til alkoholen fra ett glass vin til promilleberegningen
                // Beregn promillen på nytt.
            }
        });

        btnSpirit = (Button)findViewById(R.id.btnSpirit);
        btnSpirit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Legg til alkoholen fra et glass sprit til promilleberegningen
                // Beregn promillen på nytt.
            }
        });

        btnSexChange = (ToggleButton)findViewById(R.id.toggleSex);
        btnSexChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isMan = true;
                }else {
                    isMan = false;
                }
                //TODO Bytt kjønn. Endrer beregningsgrunnlaget
                // Beregn promillen på nytt.
            }
        });

    }
}
