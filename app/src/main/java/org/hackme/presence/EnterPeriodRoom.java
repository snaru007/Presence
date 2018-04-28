package org.hackme.presence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterPeriodRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_period_room);

        //final EditText roomNumberInput = (EditText)findViewById(R.id.roomInput);
        //final EditText periodNumberInput = (EditText)findViewById(R.id.periodInput);

        Button submitButton = findViewById(R.id.submitButton);

        final Intent goToNameList = new Intent(this, NameListActivity.class);

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //int roomNumberInt = Integer.parseInt(roomNumberInput.getText().toString());
                //int periodNumberInt = Integer.parseInt(periodNumberInput.getText().toString());

                startActivity(goToNameList);

            }

        });

    }
}
