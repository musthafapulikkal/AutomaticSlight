package com.example.musthafa.automaticslight.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

import static com.example.musthafa.automaticslight.Activity.MainActivity.MyPREFERENCES;
import static com.example.musthafa.automaticslight.Activity.MainActivity.obemail;

public class AddComplaintActivity extends AppCompatActivity {
EditText edt_post,edt_complaint;
Button btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_complaint);
        edt_post=(EditText)findViewById(R.id.post_id);
        edt_complaint=(EditText)findViewById(R.id.idcomplaintedit_text);
        btn_send=(Button)findViewById(R.id.btnsendcomplaint);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String postno=edt_post.getText().toString().trim();
                final String complaint=edt_complaint.getText().toString().trim();
                SharedPreferences shared = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
                final String email=shared.getString(obemail,null);
                if (TextUtils.isEmpty(postno))
                {
                    edt_post.setError("please fill this field");
                    edt_post.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(complaint))
                {
                    edt_complaint.setError("please fill this field");
                    edt_complaint.requestFocus();
                    return;
                }
                RequestQueue requestQueue=Volley.newRequestQueue(AddComplaintActivity.this);
                String Url="http://www.automaticslight.fabstudioz.com/add_user_complaints.php";
                StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("complaint response",response);
                        if (response.equals("success"))
                        {
                            startActivity(new Intent(getApplicationContext(),UserHomeActivity.class));
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
                        params.put("postno",postno);
                        params.put("complaint",complaint);
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });
    }
}
