package no.qvidahl.promillekalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView mPromilleTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DecimalFormat mNumberFormat = new DecimalFormat("#.##");

        final double promille = Math.random();
        final String promilleTekst = String.valueOf(mNumberFormat.format(promille));

        mPromilleTextView = (TextView)findViewById(R.id.promilleVerdi);
        mPromilleTextView.setText(String.format("%s o/oo", promilleTekst));

    }
}
