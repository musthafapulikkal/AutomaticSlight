package com.example.musthafa.automaticslight.Other;

public class Complaints {
    private String email;
    private String postno;
    private String complaint;
    public Complaints()
    {

    }
    public Complaints(String email,String postno,String complaint)
    {
        this.email=email;
        this.postno=postno;
        this.complaint=complaint;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostno() {
        return postno;
    }

    public void setPostno(String postno) {
        this.postno = postno;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}
