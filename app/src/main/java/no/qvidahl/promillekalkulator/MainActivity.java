package no.qvidahl.promillekalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView mPromilleTextView;

    private Button btnBeer;
    private Button btnWine;
    private Button btnSpirit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DecimalFormat mNumberFormat = new DecimalFormat("#.##");

        final double promille = Math.random();
        final String promilleTekst = String.valueOf(mNumberFormat.format(promille));

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

    }
}
