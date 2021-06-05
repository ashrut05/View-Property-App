package com.example.AshrutSharma_COMP304Sec004_Lab2_Ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class CheckOut extends AppCompatActivity {

    ArrayList<String> receivedIntent;
    RadioGroup propertyRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        receivedIntent = getIntent().getStringArrayListExtra("selectedApt");
        propertyRadioGroup = findViewById(R.id.propertyRadioGroup);
        getApartmentType(receivedIntent);

        Button btnProceed = findViewById(R.id.btnProceed);
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paymentType();
            }

            //Selecting class to display based on radio button selected
            private void paymentType() {
                RadioButton radioCash = findViewById(R.id.radioCash);
                RadioButton radioCredit = findViewById(R.id.radioCredit);
                RadioButton radioDebit = findViewById(R.id.radioDebit);

                if(radioCash.isChecked()){
                    Intent intent = new Intent(CheckOut.this, PaymentMade.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(CheckOut.this, CardPayment.class);
                    startActivity(intent);
                }
            }
        });
    }

    //Generating  the apartment array based on the array created from checkboxes
    private void getApartmentType(ArrayList<String> dataReceived) {
        for (String item : dataReceived) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(item);
            radioButton.setId(View.generateViewId());
            propertyRadioGroup.addView(radioButton);
        }
    }
}