package no.qvidahl.promillekalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mPromilleTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final double promille = 0.19;

        mPromilleTextView = (TextView)findViewById(R.id.promilleVerdi);
        mPromilleTextView.setText(String.valueOf(promille));

    }
}
