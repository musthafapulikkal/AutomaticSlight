package com.example.musthafa.automaticslight.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.musthafa.automaticslight.Other.Alerts;
import com.example.musthafa.automaticslight.R;

import java.util.List;

public class AlertAdapter extends RecyclerView.Adapter<AlertAdapter.MyviewHolder> {
    private List<Alerts> alertsList;
    private Context context;
    public AlertAdapter(List<Alerts> alertsList){this.alertsList=alertsList;}
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.alert_list, parent, false);
        return new MyviewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        Alerts alerts=alertsList.get(position);
        String postid=alerts.getAlert_post_id();
        if (postid.equals("3"))
        {
            holder.post_no.setText("l and 2");
            holder.complaint.setText("light id 1 and light id 2 is not working");
        }
        else {
            holder.post_no.setText(postid);
            holder.complaint.setText(alerts.getAlert_complaint());
        }
    }

    @Override
    public int getItemCount() {
        return alertsList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView post_no,complaint;
        public MyviewHolder(View itemView) {
            super(itemView);
            post_no=(TextView)itemView.findViewById(R.id.alert_post_id);
            complaint=(TextView)itemView.findViewById(R.id.alert_complaint);
        }
    }
}
