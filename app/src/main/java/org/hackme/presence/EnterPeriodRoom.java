package org.hackme.presence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EnterPeriodRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_period_room);

        final EditText roomNumberInput = (EditText)findViewById(R.id.roomInput);
        final EditText periodNumberInput = (EditText)findViewById(R.id.periodInput);

        final Spinner scheduleDay = (Spinner) findViewById(R.id.scheduleDaySpinner);

        List<String> dayLetters = new ArrayList<>();
        dayLetters.add("A");
        dayLetters.add("B");
        dayLetters.add("C");
        dayLetters.add("D");
        dayLetters.add("E");
        dayLetters.add("AX");
        dayLetters.add("BX");
        dayLetters.add("CX");

        ArrayAdapter<String> dayLettersArray = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,dayLetters);

        scheduleDay.setAdapter(dayLettersArray);

        Button submitButton = findViewById(R.id.submitButton);

        final Intent goToNameList = new Intent(this, NameListActivity.class);

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                int roomNumber = Integer.parseInt(roomNumberInput.getText().toString());
                int periodNumber = Integer.parseInt(periodNumberInput.getText().toString());

                Toast.makeText(EnterPeriodRoom.this,
                        "" + roomNumber,
                        Toast.LENGTH_LONG).show();

                goToNameList.putExtra("ROOM_NUMBER", roomNumber);
                goToNameList.putExtra("PERIOD_NUMBER", periodNumber);
                startActivity(goToNameList);

            }

        });

    }
}
