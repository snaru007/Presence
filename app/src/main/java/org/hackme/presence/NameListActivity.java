package org.hackme.presence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NameListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final Intent startRandP = new Intent(this, EnterPeriodRoom.class);

        Button submitButton = findViewById(R.id.startButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(startRandP);


            }

        });


    }
}
