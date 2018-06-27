package com.intelliarts.demkovych;


public class Data {
    private String date;
    private String product;
    private String currency;
    private int money;

    public Data(String date, String product, String currency,int money) {
        this.date = date;
        this.product = product;
        this.currency = currency;
        this.money = money;
    }

    public Data() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    @Override
    public String toString() {
        return
                "\n\n date= " + date + "\n" +
                        " product= " + product + "\n"  +
                        " currency= " + currency + "\n" +
                        " money= " + money;
    }
}
