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

        final EditText roomNumberInput = findViewById(R.id.roomInput);
        final EditText periodNumberInput = findViewById(R.id.periodInput);

        final Spinner scheduleDay = findViewById(R.id.scheduleDaySpinner);

        final List<String> dayLetters = new ArrayList<>();
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
                String periodString = periodNumberInput.getText().toString();
                int periodNumber = Integer.parseInt(periodString);
                String dayType = scheduleDay.getSelectedItem().toString();

                boolean condA = dayType.equalsIgnoreCase("A") && periodString.matches("[1234]");
                boolean condAX = dayType.equalsIgnoreCase("AX") && periodString.matches("[1234]");
                boolean condB = dayType.equalsIgnoreCase("B") && periodString.matches("[5678]");
                boolean condBX = dayType.equalsIgnoreCase("BX") && periodString.matches("[5678]");
                boolean condC = dayType.equalsIgnoreCase("C") && periodString.matches("[12345]");
                boolean condCX = dayType.equalsIgnoreCase("CX") && periodString.matches("[12345]");
                boolean condD = dayType.equalsIgnoreCase("D") && periodString.matches("[123678]");
                boolean condE = dayType.equalsIgnoreCase("E") && periodString.matches("[45678]");

                if(condA || condAX || condB || condBX || condC || condCX || condD || condE) {
                    goToNameList.putExtra("ROOM_NUMBER", roomNumber);
                    goToNameList.putExtra("PERIOD_NUMBER", periodNumber);
                    startActivity(goToNameList);
                } else {
                    Toast.makeText(EnterPeriodRoom.this, "INVALID PERIOD NUMBER", Toast.LENGTH_LONG).show();
                }

            }

        });

    }
}
