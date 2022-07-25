package com.example.mbs.api.generic;

public class UserDetails {

    String name;
    String mobile;
    String whatsApp;
    String email;

    String paymentId;

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWhatsApp() {
        return whatsApp;
    }

    public String getEmail() {
        return email;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
}
