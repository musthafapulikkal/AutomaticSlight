package com.example.musthafa.automaticslight.Activity;

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
import com.example.musthafa.automaticslight.Adapter.ComplaintAdapter;
import com.example.musthafa.automaticslight.Adapter.UserAdapter;
import com.example.musthafa.automaticslight.Other.Complaints;
import com.example.musthafa.automaticslight.Other.Users;
import com.example.musthafa.automaticslight.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ViewComplaintsActivity extends AppCompatActivity {
    private List<Complaints> complaintsList=new ArrayList<>();
    private RecyclerView recyclerView;
    private ComplaintAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_complaints);
        mAdapter = new ComplaintAdapter(complaintsList);
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        RequestQueue requestQueue=Volley.newRequestQueue(ViewComplaintsActivity.this);
        String Url="http://www.automaticslight.fabstudioz.com/viewcomplaints.php";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("complaints response",response);
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    int length=jsonArray.length();
                    for (int i=0;i<=length;i++)
                    {
                        JSONObject json=(JSONObject)jsonArray.get(i);
                        String email=json.optString("email");
                        String postno=json.optString("postno");
                        String complaint=json.optString("complaint");
                        Complaints complaints=new Complaints(email,postno,complaint);
                        complaintsList.add(complaints);
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
