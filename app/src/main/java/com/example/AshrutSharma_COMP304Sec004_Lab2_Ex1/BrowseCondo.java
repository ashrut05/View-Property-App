package com.example.AshrutSharma_COMP304Sec004_Lab2_Ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class BrowseCondo extends AppCompatActivity {
    ArrayList<String> checkedOptions = new ArrayList<>(); // Array to store selected apartments options to view, 1st element is apartment type
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_condo);

        //Checkboxes
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.chkCondo1);
        checkBox1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                    checkedOptions.add(getResources().getString(R.string.condoAddress1) + " - " + getResources().getString(R.string.condoPrice1)); //Adding apartment name and price from the strings file to the array
            }
        });

        CheckBox checkBox2 = (CheckBox) findViewById(R.id.chkCondo2);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                    checkedOptions.add(getResources().getString(R.string.condoAddress2) + " - " + getResources().getString(R.string.condoPrice2));
            }
        });

        CheckBox checkBox3 = (CheckBox) findViewById(R.id.chkCondo3);
        checkBox3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                    checkedOptions.add(getResources().getString(R.string.condoAddress3) + " - " + getResources().getString(R.string.condoPrice3));
            }
        });

        //Checkout Button
        Button checkOutButton = findViewById(R.id.btnProceed);
        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BrowseCondo.this, CheckOut.class);
                intent.putExtra("selectedApt", checkedOptions);
                startActivity(intent);
            }
        });
    }
}