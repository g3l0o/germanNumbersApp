package com.germannumbers.roger.germannumbers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class TextToNumber extends AppCompatActivity {
    TextView number;
    EditText text;
    Button checkButton;
    GermanNumber gNumber;
    String answer;
    int chances;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_number);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        number = (TextView) findViewById(R.id.NumberTextView);
        text = (EditText) findViewById(R.id.NumberEditText);
        checkButton = (Button) findViewById(R.id.checkButton);
        gNumber = new GermanNumber();

        checkButton.setOnClickListener(checkButtonAction);

        newRandom();

    }

    private void newRandom(){
        chances = 0;
        text.setText("");
        int random = ThreadLocalRandom.current().nextInt(0, 99);
        answer = gNumber.fromNumberToString(random);
        DecimalFormat myFormat = new DecimalFormat("###,###");
        number.setText(myFormat.format(random));
    }

    View.OnClickListener checkButtonAction = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String input = text.getText().toString();
            if (answer.equals(input)){
                Toast.makeText(getBaseContext(), "Correcto!", Toast.LENGTH_SHORT).show();
                newRandom();
            }else{
                chances++;
                if (chances == 2){
                    text.setText(answer);
                    Toast.makeText(getBaseContext(), "Intentemos el siguiente", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getBaseContext(), "Intentalo de nuevo", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

}
