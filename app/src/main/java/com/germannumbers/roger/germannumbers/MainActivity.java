package com.germannumbers.roger.germannumbers;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button numbersTable;
    Button writeString;
    Button writeNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numbersTable = (Button) findViewById(R.id.NumbersButton);
        writeString = (Button) findViewById(R.id.writeWithLetter);
        writeNumber = (Button) findViewById(R.id.writeNumber);

        numbersTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent numbersTable = new Intent(getBaseContext(), NumbersTable.class);
                startActivity(numbersTable);

            }
        });

        writeNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersTable = new Intent(getBaseContext(), TextToNumber.class);
                startActivity(numbersTable);
            }
        });

        writeString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersTable = new Intent(getBaseContext(), NumberToText.class);
                startActivity(numbersTable);
            }
        });
    }
}
