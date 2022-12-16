package eu.tutorials.food_delivery_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import eu.tutorials.food_delivery_app.R;

public class IntroActivity extends AppCompatActivity {

    private ConstraintLayout startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        startBtn = findViewById(R.id.startBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this,MainActivity.class);
                startActivity(intent);
                //startActivity(new Intent(IntroActivity.this,MainActivity.class));
            }
        });
    }
}