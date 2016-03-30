package com.example.iankearns.test1;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Speed extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);
        this.setTitle(MainActivity.givenTitle + ": SpeedActivity");

        //setup button listener
        Button startButton = (Button) findViewById(R.id.button1);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();

            }
        });
    }
}
