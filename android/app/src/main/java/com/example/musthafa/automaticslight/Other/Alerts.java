package com.example.musthafa.automaticslight.Other;

public class Alerts {
    private String alert_post_id;
    private String alert_complaint;
    public Alerts()
    {

    }
    public Alerts(String alert_post_id,String alert_complaint)
    {
        this.alert_post_id=alert_post_id;
        this.alert_complaint=alert_complaint;
    }

    public String getAlert_post_id() {
        return alert_post_id;
    }

    public void setAlert_post_id(String alert_post_id) {
        this.alert_post_id = alert_post_id;
    }

    public String getAlert_complaint() {
        return alert_complaint;
    }

    public void setAlert_complaint(String alert_complaint) {
        this.alert_complaint = alert_complaint;
    }
}
