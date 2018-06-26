package com.intelliarts.demkovych;


public class Data {
    private String date;
    private String product;
    private String money;
    private String currency;

    public Data(String date, String product, String money, String currency) {
        this.date = date;
        this.product = product;
        this.money = money;
        this.currency = currency;
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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return
                "\n\n date= " + date + "\n" +
                        " product= " + product + "\n"  +
                        " money= " + money + "\n" +
                        " currency= " + currency;
    }
}
