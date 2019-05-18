package com.example.musthafa.automaticslight.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.musthafa.automaticslight.Other.Users;
import com.example.musthafa.automaticslight.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockedAdapter extends RecyclerView.Adapter<BlockedAdapter.MyviewHolder> {
    private List<Users> usersList;
    public BlockedAdapter(List<Users> usersList){
        this.usersList=usersList;
    }
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.blocked_list, parent, false);
        return new MyviewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        final Users users=usersList.get(position);
        holder.consumer_no.setText(users.getConsumer_no());
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView consumer_no;
        Button btn_unblock;
        public MyviewHolder(View itemView) {
            super(itemView);
            consumer_no=(TextView)itemView.findViewById(R.id.id_blk_user_c_no);
            btn_unblock=(Button)itemView.findViewById(R.id.id_btn_userunblock);
            btn_unblock.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    unblock(getAdapterPosition());
                }
            });
        }
    }

    private void unblock(int adapterPosition) {
        if (usersList.size()==0)
        {

        }
        else
        {
            final Users user=usersList.get(adapterPosition);
            Toast.makeText(user.getContext(), "unblocked", Toast.LENGTH_SHORT).show();
            usersList.remove(adapterPosition);
            notifyItemRemoved(adapterPosition);
            notifyItemRangeChanged(adapterPosition,usersList.size());
            RequestQueue requestQueue=Volley.newRequestQueue(user.getContext());
            String Url="http://www.automaticslight.fabstudioz.com/unblockusers.php";
            StringRequest stringRequest=new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params=new HashMap<>();
                    params.put("consumerno",user.getConsumer_no());
                    return params;
                }
            };
            requestQueue.add(stringRequest);
        }
    }
    }

