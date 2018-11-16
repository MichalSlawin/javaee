package com.javaee.doorstore.domain;

public class Rodo {
    private boolean personalDataConsent = false;
    private boolean cookiesConsent = false;
    private boolean kidneyConsent = true;

    public Rodo() {
    }

    public boolean isPersonalDataConsent() {
        return personalDataConsent;
    }

    public void setPersonalDataConsent(boolean personalDataConsent) {
        this.personalDataConsent = personalDataConsent;
    }

    public boolean isCookiesConsent() {
        return cookiesConsent;
    }

    public void setCookiesConsent(boolean cookiesConsent) {
        this.cookiesConsent = cookiesConsent;
    }

    public boolean isKidneyConsent() {
        return kidneyConsent;
    }

    public void setKidneyConsent(boolean kidneyConsent) {
        this.kidneyConsent = kidneyConsent;
    }
}
