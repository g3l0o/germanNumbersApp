package com.germannumbers.roger.germannumbers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class NumberToText extends AppCompatActivity {

    TextView stringNumber;
    EditText writeNumber;
    Button check;
    GermanNumber germanNumber;
    int chances;
    int answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_to_text);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        stringNumber = (TextView) findViewById(R.id.StringTextView);
        writeNumber = (EditText) findViewById(R.id.NumberEditText);
        check = (Button) findViewById(R.id.checkButton2);
        germanNumber = new GermanNumber();

        check.setOnClickListener(checkButtonAction);

        newRandom();
    }

    private void newRandom(){
        writeNumber.setText("");
        answer = ThreadLocalRandom.current().nextInt(0, 99);
        String numberText = germanNumber.fromNumberToString(answer);
        stringNumber.setText(numberText);
    }

    View.OnClickListener checkButtonAction = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int input = Integer.parseInt(writeNumber.getText().toString());
            if (answer - input == 0){
                Toast.makeText(getBaseContext(), "Correcto!", Toast.LENGTH_SHORT).show();
                newRandom();
            }else{
                chances++;
                if (chances == 2){
                    writeNumber.setText(""+answer);
                    Toast.makeText(getBaseContext(), "Intentemos el siguiente", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getBaseContext(), "Intentalo de nuevo", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };
}
