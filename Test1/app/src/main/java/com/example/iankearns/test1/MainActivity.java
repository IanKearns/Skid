package com.example.iankearns.test1;

import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int skidDistance;
    private int velocity;
    private EditText inputTextEdit; // user enters number to add in this EditText
    Context context;
    static String givenTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        givenTitle = (String) this.getTitle();
        context = getApplicationContext();

        Button calculateButton = (Button) findViewById(R.id.button);
        inputTextEdit = (EditText) findViewById(R.id.editText); // inflate EditText

        assert calculateButton != null;
        calculateButton.setOnClickListener(new View.OnClickListener() { // 'Listen' to calculateButton
            public void onClick(View v) { // if here the calculateButton has been clicked, so add
                inputTextEdit.getText().toString();
                try { // if the user entered a non integer, then next line will go horribly wrong..
                    skidDistance = Integer.parseInt(inputTextEdit.getText() // attempt convert to int
                            .toString());
                } catch (NumberFormatException e) { // if not int then let user know with a toast
                    skidDistance = 0; // No new input, so clear last input
                    Toast.makeText(context,
                            "Error: You didn't enter an integer!",
                            Toast.LENGTH_SHORT).show();
                }
                velocity = skidDistance * 177;
                startCalculator();
            }

        });
    }

    private void startCalculator() {

        this.setTitle(givenTitle + ": Calculator");
        Intent launchCalculator = new Intent(MainActivity.this, Speed.class);
        startActivity(launchCalculator);
    }
}
