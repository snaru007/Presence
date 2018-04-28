package org.hackme.presence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class NameListActivity extends AppCompatActivity implements View.OnClickListener {
    public Button button1;
    public Button button2;
    public Button button3;
    public Button reportButton;
    public Button[] buttons;
    public String name;
    //TODO: make dynamic
    public int numStudents = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_list);
        getIntent().getStringExtra("LOGGED_IN_STUDENT");
        int roomNumber = getIntent().getIntExtra("ROOM_NUMBER", 0);
        int periodNumber = getIntent().getIntExtra("PERIOD_NUMBER", 0);
        String  dayType = getIntent().getStringExtra("DAY_LETTER");
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        buttons = new Button[numStudents];
        buttons[1] = button1;
        buttons[2] = button2;
        buttons[3] = button3;
        reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent report = new Intent(getBaseContext(), AttendanceReportActivity.class);
                boolean[] studentsSignedIn = new boolean[numStudents];
                studentsSignedIn[1] = !button1.isEnabled();
                studentsSignedIn[2] = !button2.isEnabled();
                studentsSignedIn[3] = !button3.isEnabled();
                report.putExtra("STUDENTS_SIGNED_IN", studentsSignedIn);
                startActivity(report);
            }
        });
    }

    public void onClick(View v) {
        Button b = (Button) v;
        b.setEnabled(false);
        name = b.getText().toString();
        Intent login = new Intent(getBaseContext(), LoginActivity.class);
        login.putExtra("STUDENT_NAME", name);
        startActivity(login);
    }
}
