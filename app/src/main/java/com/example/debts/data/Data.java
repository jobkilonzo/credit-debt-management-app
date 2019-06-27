package com.example.debts.data;

public class Data {

    private String name;
    private int amount;
    private String note;
    private String date;
    private String id;

    public Data(){

    }
    public Data(String name, int amount, String note, String date, String id) {
        this.name = name;
        this.amount = amount;
        this.note = note;
        this.date = date;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
