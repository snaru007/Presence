package org.hackme.presence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class NameListActivity extends AppCompatActivity implements View.OnClickListener {
    public Button button1;
    public Button button2;
    public Button button3;
    //public List<Button> buttons;
    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_list);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        int roomNumber = getIntent().getIntExtra("ROOM_NUMBER", 0);
        int periodNumber = getIntent().getIntExtra("PERIOD_NUMBER", 0);


        //buttons.add(button1);
        //buttons.add(button2);
        //buttons.add(button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        ViewGroup layout = (ViewGroup) findViewById(R.id.nameList);
        /*for (Button b : buttons) {
            layout.addView(b);
        }*/
    }

    public void onClick(View v) {
        Button b = (Button) v;
        name = b.getText().toString();
        button1.setText(name);
        button2.setText(name);
        button3.setText(name);
        Intent login = new Intent(getBaseContext(), LoginActivity.class);
        login.putExtra("STUDENT_NAME", name);
        startActivity(login);
        Log.d("NAME", name);
    }
}
