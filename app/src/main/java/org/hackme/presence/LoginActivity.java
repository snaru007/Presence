package org.hackme.presence;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public String studentName;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_list);
        studentName = getIntent().getStringExtra("STUDENT_NAME");
        Log.d("LOGIN", "made it to login");
    }

    public void onClick(View v) {
    }
}
