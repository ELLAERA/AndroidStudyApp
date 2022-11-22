package com.example.androidstudyapp.retrofit;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NaturalGasData {
    @SerializedName("연도")
    @Expose
    private String year;

    @SerializedName("최소운영재고")
    @Expose
    private String min_stock;

    @SerializedName("최대운영재고")
    @Expose
    private String max_stock;

    @SerializedName("재고")
    @Expose
    private String stock;

    @SerializedName("재고율")
    @Expose
    private String stock_rate;

    public NaturalGasData(String year, String min_stock, String max_stock, String stock, String stock_rate) {
        this.year = year;
        this.min_stock = min_stock;
        this.max_stock = max_stock;
        this.stock = stock;
        this.stock_rate = stock_rate;
    }

    public String getYear() {
        return year;
    }
    public String getMin_stock() {
        return min_stock;
    }
    public String getMax_stock() {
        return max_stock;
    }
    public String getStock() {
        return stock;
    }
    public String getStock_rate() {
        return stock_rate;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public void setMin_stock(String min_stock) {
        this.min_stock = min_stock;
    }
    public void setMax_stock(String max_stock) {
        this.max_stock = max_stock;
    }
    public void setStock(String stock) {
        this.stock = stock;
    }
    public void setStock_rate(String stock_rate) {
        this.stock_rate = stock_rate;
    }


    @NonNull
    @Override
    public String toString() {
        return  "\n\n" + year + "년" +
                "\n최소 : " + min_stock + "t " +
                " 최대 : " + max_stock + "t" +
                "\n재고 : " + stock + "t " +
                " 재고율 : " + stock_rate + "%";
    }
}