package com.example.musthafa.automaticslight.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.musthafa.automaticslight.R;

public class AdminHomeActivity extends AppCompatActivity {
Button btn_view_user,btn_view_complaint,btn_viewalerts,btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        btn_view_user=(Button)findViewById(R.id.id_btn_adusers);
        btn_view_complaint=(Button)findViewById(R.id.id_btn_complaints);
        btn_logout=(Button)findViewById(R.id.id_btn_exit);
        btn_viewalerts=(Button)findViewById(R.id.id_btn_alerts);
        btn_view_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AdminViewUserActivity.class));
            }
        });
        btn_view_complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ViewComplaintsActivity.class));
            }
        });
        btn_viewalerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ViewAlertActivity.class));
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

    }
}
