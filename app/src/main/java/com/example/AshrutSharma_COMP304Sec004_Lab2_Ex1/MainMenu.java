package com.example.AshrutSharma_COMP304Sec004_Lab2_Ex1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {
   //Button variables for all menu options
    private Button btnApartment;
    private Button btnDetached;
    private Button btnSemi;
    private Button btnCondo;
    private Button btnTownHouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnApartment = (Button) findViewById(R.id.btnApartment);
        btnApartment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openApartmentList();
            } //Methods for opening an activity for each button
        });
        btnDetached = (Button) findViewById(R.id.btnDetached);
        btnDetached.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openDetachedList();
            }
        });
        btnSemi = (Button) findViewById(R.id.btnSemi);
        btnSemi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openSemiList();
            }
        });
        btnCondo = (Button) findViewById(R.id.btnCondo);
        btnCondo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openCondoList();
            }
        });
        btnTownHouse = (Button) findViewById(R.id.btnTownHouse);
        btnTownHouse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openTownHouseList();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_types_menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.apartment:
                Toast.makeText(this, "Apartment Selected",Toast.LENGTH_SHORT).show();
                openApartmentList();
                return true;
            case R.id.detached:
                Toast.makeText(this, "Detached Home Selected",Toast.LENGTH_SHORT).show();
                openDetachedList();
                return true;
            case R.id.semi:
                Toast.makeText(this, "Semi-Detached Selected",Toast.LENGTH_SHORT).show();
                openSemiList();
                return true;
            case R.id.condo:
                Toast.makeText(this, "Condominium Selected",Toast.LENGTH_SHORT).show();
                openCondoList();
                return true;
            case R.id.townHouse:
                Toast.makeText(this, "Town House Selected",Toast.LENGTH_SHORT).show();
                openTownHouseList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Methods for opening different activity called based on which option is selcted in the menu or which button is pressed on the menu page
    public void openApartmentList() {
        Intent intent = new Intent(this, BrowseApartment.class);
        startActivity(intent);
    }

    public void openDetachedList() {
        Intent intent = new Intent(this, BrowseDetached.class);
        startActivity(intent);
    }

    public void openSemiList() {
        Intent intent = new Intent(this, BrowseSemi.class);
        startActivity(intent);
    }

    public void openCondoList() {
        Intent intent = new Intent(this, BrowseCondo.class);
        startActivity(intent);
    }

    public void openTownHouseList() {
        Intent intent = new Intent(this, BrowseTownHouse.class);
        startActivity(intent);
    }

}