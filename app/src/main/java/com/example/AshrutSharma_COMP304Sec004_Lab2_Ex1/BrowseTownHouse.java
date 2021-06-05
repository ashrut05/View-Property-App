package com.example.AshrutSharma_COMP304Sec004_Lab2_Ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class BrowseTownHouse extends AppCompatActivity {
    ArrayList<String> checkedOptions = new ArrayList<>(); // Array to store selected apartments options to view, 1st element is apartment type

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_town_house);

        //CheckBoxes
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.chkTown1);
        checkBox1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                    checkedOptions.add(getResources().getString(R.string.townAddress1) + " - " + getResources().getString(R.string.townPrice1)); //Adding apartment name and price from the strings file to the array
            }
        });

        CheckBox checkBox2 = (CheckBox) findViewById(R.id.chkTown2);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                    checkedOptions.add(getResources().getString(R.string.townAddress2) + " - " + getResources().getString(R.string.townPrice2));
            }
        });

        CheckBox checkBox3 = (CheckBox) findViewById(R.id.chkTown3);
        checkBox3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                    checkedOptions.add(getResources().getString(R.string.townAddress3) + " - " + getResources().getString(R.string.townPrice3));
            }
        });

        //Checkout Button
        Button checkOutButton = findViewById(R.id.btnProceed);
        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BrowseTownHouse.this, CheckOut.class);
                intent.putExtra("selectedApt", checkedOptions);
                startActivity(intent);
            }
        });
    }
}