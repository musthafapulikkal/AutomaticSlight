package com.example.musthafa.automaticslight.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.musthafa.automaticslight.R;

import static com.example.musthafa.automaticslight.Activity.MainActivity.obemail;

public class UserHomeActivity extends AppCompatActivity {
Button btn_make_complaiint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        btn_make_complaiint=(Button)findViewById(R.id.id_make_complaint);
        btn_make_complaiint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddComplaintActivity.class));
            }
        });
        findViewById(R.id.id_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences =getSharedPreferences(obemail,Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
    }
}
