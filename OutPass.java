package com.example.android.sritautomatedsystem;


public class OutPass {

    private String Id;

    private String Register;

    private String FromDate;

    private String ToDate;

    private String Reason;

    private String Acceptance;

    public OutPass(String id, String register, String fromDate, String toDate, String reason, String acceptance) {
        Id = id;
        Register = register;
        FromDate = fromDate;
        ToDate = toDate;
        Reason = reason;
        Acceptance = acceptance;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getRegister() {
        return Register;
    }

    public void setRegister(String register) {
        Register = register;
    }

    public String getFromDate() {
        return FromDate;
    }

    public void setFromDate(String fromDate) {
        FromDate = fromDate;
    }

    public String getToDate() {
        return ToDate;
    }

    public void setToDate(String toDate) {
        ToDate = toDate;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getAcceptance() {
        return Acceptance;
    }

    public void setAcceptance(String acceptance) {
        Acceptance = acceptance;
    }

    public OutPass() {
    }
}

