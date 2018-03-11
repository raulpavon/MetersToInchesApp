package com.example.rulol_lio.meterstoinches;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
        1m = 39.3701in
        1in =0.0254m
     */

    private EditText enterMeters;
    private Button convertButton;
    private TextView resultTextView;
    private RadioButton mRadioButton;
    private RadioButton pRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterMeters = (EditText)findViewById(R.id.metersedittext);
        convertButton = (Button)findViewById(R.id.convertButtonID);
        resultTextView = (TextView)findViewById(R.id.resultid);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Conversion Logic
                double multiplier = 39.3701;
                double result = 0.0;

                if (enterMeters.getText().toString().equals("")){
                    resultTextView.setText(R.string.error_message);
                    resultTextView.setTextColor(Color.RED);
                }
                else {
                    double meterValue = Double.parseDouble(enterMeters.getText().toString());

                    result = meterValue * multiplier;

                    resultTextView.setTextColor(Color.BLACK);
                    resultTextView.setText(String.format("%.2f", result) + " inches");
                }
            }
        });
    }
}
