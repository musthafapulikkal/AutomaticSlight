package com.example.musthafa.automaticslight.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.musthafa.automaticslight.R;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {
EditText edt_username,edt_email,edt_password,edt_cno;
Button btn_register;
TextView txt_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        edt_username=(EditText)findViewById(R.id.id_user_name);
        edt_email=(EditText)findViewById(R.id.id_user_email);
        edt_password=(EditText)findViewById(R.id.id_user_password);
        edt_cno=(EditText)findViewById(R.id.id_user_cno);
        txt_login=(TextView)findViewById(R.id.txtlogin);
        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
        btn_register=(Button)findViewById(R.id.id_btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username=edt_username.getText().toString().trim();
                final String email=edt_email.getText().toString().trim();
                final String password=edt_password.getText().toString().trim();
                final String cno=edt_cno.getText().toString().trim();
                if (TextUtils.isEmpty(username))
                {
                    edt_username.setError("please fill this field");
                    edt_username.requestFocus();
                    return;
                }
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    edt_email.setError("Enter a valid email");
                    edt_email.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(email))
                {
                    edt_email.setError("please fill this field");
                    edt_email.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(password))
                {
                    edt_password.setError("please fill this field");
                    edt_password.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(cno))
                {
                    edt_cno.setError("please fill this field");
                    edt_cno.requestFocus();
                    return;
                }
                RequestQueue requestQueue=Volley.newRequestQueue(RegistrationActivity.this);
                String Url="http://www.automaticslight.fabstudioz.com/registration.php";
                StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("registration response",response);
                        if (response.equals(email))
                        {
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                        }
                        else if (response.equals("invalid"))
                        {
                            Toast.makeText(RegistrationActivity.this, "already registered", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params=new HashMap<>();
                        params.put("username",username);
                        params.put("email",email);
                        params.put("password",password);
                        params.put("consumerno",cno);
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });

    }
}
