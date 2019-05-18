package com.example.musthafa.automaticslight.Other;

import android.content.Context;

public class Users
{
    //private String email;
    private String consumer_no;
    //private String status;
    private Context context;
    public Users()
    {
    }
    public Users(String consumer_no,Context context)
    {

        this.consumer_no=consumer_no;
        this.context=context;

    }



    public String getConsumer_no() {
        return consumer_no;
    }

    public void setConsumer_no(String consumer_no) {
        this.consumer_no = consumer_no;
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
