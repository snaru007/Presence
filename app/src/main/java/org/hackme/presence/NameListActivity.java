package org.hackme.presence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class NameListActivity extends AppCompatActivity implements View.OnClickListener {
    public Button button1;
    public Button button2;
    public Button button3;
    public String name;
    public final Intent login = new Intent(this, LoginActivity.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_list);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    public void onClick(View v) {
        Button b = (Button) v;
        name = b.getText().toString();
        //startActivity(login);
    }
}
