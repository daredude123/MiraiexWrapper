package com.andynordevelop.miraiexwrapper.domain;

public class MiraiexPairHistory {

    String type;
    double amount;
	double price;
    String created_at;
	double total;

    public MiraiexPairHistory() {
    }

    public MiraiexPairHistory(String type, double amount, double price, String created_at, double total) {
        this.type = type;
        this.amount = amount;
        this.price = price;
        this.created_at = created_at;
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "MiraiexPairHistory{" +
                "type='" + type + '\'' +
                ", amount='" + amount + '\'' +
                ", price='" + price + '\'' +
                ", created_at='" + created_at + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
