package org.hackme.presence;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class NameListActivity extends AppCompatActivity implements View.OnClickListener {
    public Button button1;
    public Button button2;
    public Button button3;
    public String name;
    public Calendar calendar;
    private int roomNumber;
    private int periodNumber;
    private String dayType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_list);
        getIntent().getStringExtra("LOGGED_IN_STUDENT");
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        int roomNumber = getIntent().getIntExtra("ROOM_NUMBER", 0);
        int periodNumber = getIntent().getIntExtra("PERIOD_NUMBER", 0);
        String  dayType = getIntent().getStringExtra("DAY_LETTER");

        calendar = new GregorianCalendar();

        //buttons.add(button1);
        //buttons.add(button2);
        //buttons.add(button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    public void onClick(View v) {
        Button b = (Button) v;
        b.setEnabled(false);
        name = b.getText().toString();
        Intent login = new Intent(getBaseContext(), LoginActivity.class);
        login.putExtra("STUDENT_NAME", name);
        int currentMin = calendar.get(Calendar.MINUTE);
        int currentHour = calendar.get(Calendar.HOUR);

        Toast.makeText(NameListActivity.this,currentHour +":"+ currentMin, Toast.LENGTH_LONG).show();
        boolean isTardy = false;

        switch(dayType) {
            case "A":
                switch(periodNumber) {
                    case 1:
                        isTardy = !(currentHour < 8 || (currentHour == 8 && currentMin <= 2));
                        break;
                    case 2:
                        isTardy = !(currentHour < 9 || (currentHour == 9 && currentMin <= 30));
                        break;
                    case 3:
                        String rn = roomNumber + "";
                        if(rn.charAt(0) == '1') {
                            isTardy = !(currentHour < 11 || (currentHour == 11 && currentMin <= 17));
                        } else if(rn.charAt(0) == '2') {
                            isTardy = !(currentHour < 10 || (currentHour == 10 && currentMin <= 52));
                        }
                        break;
                    case 4:
                        isTardy = !(currentHour < 1 || (currentHour == 1 && currentMin <= 4));
                        break;
                    default: break;
                }
            case "AX":
                break;
            case "B":
                break;
            case "BX":
                break;
        }
        login.putExtra("Tardy", isTardy);
        startActivity(login);
    }
}
