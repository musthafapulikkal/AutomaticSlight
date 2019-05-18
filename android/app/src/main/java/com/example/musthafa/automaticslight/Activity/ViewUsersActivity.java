package com.example.musthafa.automaticslight.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.musthafa.automaticslight.Adapter.UserAdapter;
import com.example.musthafa.automaticslight.Other.Users;
import com.example.musthafa.automaticslight.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ViewUsersActivity extends AppCompatActivity {
    private List<Users> usersList=new ArrayList<>();
    private RecyclerView recyclerView;
    private UserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_users);
        mAdapter = new UserAdapter(usersList);
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        RequestQueue requestQueue=Volley.newRequestQueue(ViewUsersActivity.this);
        String Url="http://www.automaticslight.fabstudioz.com/viewusers.php";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("view user response",response);
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    int length=jsonArray.length();
                    Context context=getApplicationContext();
                    for (int i=0;i<=length;i++)
                    {
                        JSONObject jsonObject=(JSONObject)jsonArray.get(i);
                        String email=jsonObject.optString("email");
                        String consumer_no=jsonObject.optString("consumerno");
                        //String status=jsonObject.optString("status");
                        Users users=new Users(consumer_no,context);
                        usersList.add(users);
                        mAdapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }
}
