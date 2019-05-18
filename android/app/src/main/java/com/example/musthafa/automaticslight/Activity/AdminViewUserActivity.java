package com.example.musthafa.automaticslight.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.musthafa.automaticslight.R;

public class AdminViewUserActivity extends AppCompatActivity {
Button btn_requsts,btn_block,btn_activeuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_user);
        btn_requsts=(Button)findViewById(R.id.id_requst_user);
        btn_block=(Button)findViewById(R.id.id_blocked_user);
        btn_activeuser=(Button)findViewById(R.id.id_active_user);
        btn_requsts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ViewUsersActivity.class));

            }
        });
        btn_block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),BlockedUsersActivity.class));

            }
        });
        btn_activeuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ActiveUsersActivity.class));

            }
        });
    }
}
