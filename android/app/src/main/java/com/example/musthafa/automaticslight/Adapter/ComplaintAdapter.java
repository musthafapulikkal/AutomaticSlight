package com.example.musthafa.automaticslight.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.musthafa.automaticslight.Other.Complaints;
import com.example.musthafa.automaticslight.R;

import java.util.List;

public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintAdapter.MyviewHolder> {
    private List<Complaints> complaintsList;
    private Context context;
    public ComplaintAdapter(List<Complaints> complaintsList)
    {
        this.complaintsList=complaintsList;
    }
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.complaint_list, parent, false);
        return new MyviewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        Complaints complaints=complaintsList.get(position);
        holder.email.setText(complaints.getEmail());
        holder.postno.setText(complaints.getPostno());
        holder.complaint.setText(complaints.getComplaint());
    }

    @Override
    public int getItemCount() {
        return complaintsList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView email,postno,complaint;
        public MyviewHolder(View itemView) {
            super(itemView);
            email=(TextView)itemView.findViewById(R.id.c_u_email);
            postno=(TextView)itemView.findViewById(R.id.post_no);
            complaint=(TextView)itemView.findViewById(R.id.c_u_complaint_id);
        }
    }
}
