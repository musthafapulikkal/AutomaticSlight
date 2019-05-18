package com.example.musthafa.automaticslight.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class MainActivity extends AppCompatActivity {
EditText edt_email,edt_password;
Button btn_login;
TextView registration;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String obemail = "namelKey";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_email=(EditText)findViewById(R.id.id_email);
        edt_password=(EditText)findViewById(R.id.id_password);
        registration=(TextView)findViewById(R.id.id_text_registration);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        btn_login=(Button)findViewById(R.id.id_btn_login);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email=edt_email.getText().toString().trim();
                final String password=edt_password.getText().toString().trim();
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
                if (email.equals("admin@gmail.com")&&password.equals("automaticslight"))
                {
                    startActivity(new Intent(getApplicationContext(),AdminHomeActivity.class));
                    edt_email.getText().clear();
                    edt_password.getText().clear();

                }
                else
                {
                    userLogin();
                }
            }
        });

    }

    private void userLogin() {
        final String email=edt_email.getText().toString().trim();
        final String password=edt_password.getText().toString().trim();
        RequestQueue requestQueue=Volley.newRequestQueue(MainActivity.this);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(obemail,email);
        editor.apply();
        String Url="http://www.automaticslight.fabstudioz.com/login.php";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                Log.v("login response",response);
                if (response.equals(email))
                {
                    startActivity(new Intent(getApplicationContext(),UserHomeActivity.class
                    ));
                    edt_email.getText().clear();
                    edt_password.getText().clear();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "invalid username or password", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("email",email);
                params.put("password",password);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
