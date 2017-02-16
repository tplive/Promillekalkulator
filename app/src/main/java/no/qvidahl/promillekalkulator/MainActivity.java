package no.qvidahl.promillekalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Logging
    private static final String TAG = "MainActivity";

    // UI elements
    private TextView mPromilleTextView;
    private TextView mHours;
    private TextView mWeight;
    private Button btnBeer;
    private Button btnWine;
    private Button btnSpirit;
    private Button btnReset;
    private ToggleButton btnSexChange; //https://developer.android.com/guide/topics/ui/controls/togglebutton.html
    private SeekBar seekBarHours;

    // User variables, initialize app
    private boolean isMan = false;
    private double consumedAlcohol = 0.0;
    private double weight = 65;
    private int hoursPassed = 0;

    protected void updateUI() {
        mPromilleTextView.setText(promilleTekst(calculateBloodAlcoholLevel(this.weight, this.isMan, this.consumedAlcohol, this.hoursPassed)));
        mHours.setText(String.format("%s Hours", this.hoursPassed));
        mWeight.setText(String.valueOf(this.weight));
        seekBarHours.setProgress(this.hoursPassed);
    }

    protected void resetApp() {
        this.hoursPassed = 0;
        this.weight = 65;
        this.consumedAlcohol = 0.0;
        this.isMan = false;
        updateUI();
    }


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
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt("hoursPassed", this.hoursPassed);
        savedInstanceState.putDouble("weight", this.weight);
        savedInstanceState.putDouble("consumedAlcohol", this.consumedAlcohol);
        savedInstanceState.putBoolean("isMan", this.isMan);
        //savedInstanceState.putDouble("promille", calculateBloodAlcoholLevel(this.weight, this.isMan, this.consumedAlcohol, this.hoursPassed));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.hoursPassed = savedInstanceState.getInt("hoursPassed");
            this.weight = savedInstanceState.getDouble("weight");
            this.consumedAlcohol = savedInstanceState.getDouble("consumedAlcohol");
            this.isMan = savedInstanceState.getBoolean("isMan");
        }

        setContentView(R.layout.activity_main);


        final UnitOfAlcohol beer = new UnitOfAlcohol((String) getResources().getText(R.string.btnBeer_Text), 15, 33, 4.5);
        final UnitOfAlcohol wine = new UnitOfAlcohol((String) getResources().getText(R.string.btnWine_Text), 15, 25, 14);
        final UnitOfAlcohol spirit = new UnitOfAlcohol((String) getResources().getText(R.string.btnSpirit_Text), 15, 4, 40);

        mHours = (TextView) findViewById(R.id.tvHours);

        mWeight = (TextView) findViewById(R.id.editText_Weight);
        mWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // http://stackoverflow.com/questions/7474319/how-to-parse-a-double-from-edittext-to-textview-android
                String strWeight = mWeight.getText().toString();

                if (strWeight == null || strWeight.isEmpty()) {
                    weight = 0.0;
                }else {
                    weight = Double.parseDouble(strWeight.toString());

                    if (weight <= 1.0)
                        weight = 1.0;
                    if (weight >= 300)
                        weight = 300;
                }

                }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPromilleTextView = (TextView) findViewById(R.id.promilleVerdi);
        mPromilleTextView.setText(promilleTekst(0.0));

        btnBeer = (Button) findViewById(R.id.btnBeer);
        if (beer.getConsumedNumber() > 0) {
            btnBeer.setText(beer.getName() + " " + beer.getStrength() + "% " + beer.getConsumedNumber());
        }else {
            btnBeer.setText(beer.getName() + " " + beer.getStrength() + "%");
        }
        btnBeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consumedAlcohol = consumedAlcohol + beer.getAlcoholAmount();
                beer.consumeOne();
                updateUI();
            }
        });
        btnWine = (Button) findViewById(R.id.btnWine);
        if (wine.getConsumedNumber() > 0) {
            btnWine.setText(wine.getName() + " " + wine.getStrength() + "% " + wine.getConsumedNumber());
        }else {
            btnWine.setText(wine.getName() + " " + wine.getStrength() + "%");
        }
        btnWine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consumedAlcohol = consumedAlcohol + wine.getAlcoholAmount();
                wine.consumeOne();
                updateUI();
            }
        });

        btnSpirit = (Button) findViewById(R.id.btnSpirit);
        Log.i(TAG, String.valueOf(spirit.getConsumedNumber()));
        if (spirit.getConsumedNumber() > 0) {
            btnSpirit.setText(spirit.getName() + " " + spirit.getStrength() + "% " + spirit.getConsumedNumber());
        }else {
            btnSpirit.setText(spirit.getName() + " " + spirit.getStrength() + "%");
        }
        btnSpirit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consumedAlcohol = consumedAlcohol + spirit.getAlcoholAmount();
                spirit.consumeOne();
                updateUI();
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
                updateUI();
            }
        });

        btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetApp();
            }
        });



        seekBarHours = (SeekBar) findViewById(R.id.seekBar);
        seekBarHours.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
                hoursPassed = seekBar.getProgress();
                updateUI();
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean isIt) {
                hoursPassed = seekBar.getProgress();
                updateUI();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                hoursPassed = seekBar.getProgress();
                updateUI();
            }
        });



        updateUI();
    }



}
