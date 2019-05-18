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
import com.example.musthafa.automaticslight.Adapter.BlockedAdapter;
import com.example.musthafa.automaticslight.Adapter.UserAdapter;
import com.example.musthafa.automaticslight.Other.Users;
import com.example.musthafa.automaticslight.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BlockedUsersActivity extends AppCompatActivity {
private List<Users> usersList=new ArrayList<>();
RecyclerView recyclerView;
BlockedAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocked_users);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_blocked_users);
        mAdapter = new BlockedAdapter(usersList);
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        RequestQueue requestQueue=Volley.newRequestQueue(BlockedUsersActivity.this);
        String Url="http://www.automaticslight.fabstudioz.com/viewblockedusers.php";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("blockedresponse",response);
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    Context context=getApplicationContext();
                    for (int i=0;i<=jsonArray.length();i++)
                    {
                        JSONObject jsonObject=(JSONObject)jsonArray.get(i);
                        String consumer_no=jsonObject.optString("consumerno");
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
