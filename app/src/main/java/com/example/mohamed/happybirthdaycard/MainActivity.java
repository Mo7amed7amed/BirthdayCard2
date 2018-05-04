package com.example.mohamed.happybirthdaycard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt1, txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView) findViewById(R.id.mName3);
        txt2 = (TextView) findViewById(R.id.mFriedName3);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String friend_name = bundle.getString("friend_name");
        String greeting =getResources().getString(R.string.greeting);
        String from =getResources().getString(R.string.from_);
        txt2.setText(greeting + " " + friend_name);
        txt1.setText(from + " " + name+" "+"!");
    }
}
