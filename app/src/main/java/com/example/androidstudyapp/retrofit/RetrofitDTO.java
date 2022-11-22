package com.example.androidstudyapp.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrofitDTO {
    @SerializedName("page")
    @Expose
    private int page;

    @SerializedName("perPage")
    @Expose
    private int perPage;

    @SerializedName("totalCount")
    @Expose
    private int totalCount;

    @SerializedName("currentCount")
    @Expose
    private int currentCount;

    @SerializedName("matchCount")
    @Expose
    private int matchCount;

    @SerializedName("data")
    @Expose
    private NaturalGasData[] naturalGasData;


    public int getPage ()
    {
        return page;
    }
    public int getPerPage ()
    {
        return perPage;
    }
    public int getTotalCount ()
    {
        return totalCount;
    }
    public int getCurrentCount ()
    {
        return currentCount;
    }
    public int getMatchCount ()
    {
        return matchCount;
    }
    public NaturalGasData[] getNaturalGasData()
    {
        return naturalGasData;
    }

    public void setPage (int page)
    {
        this.page = page;
    }
    public void setPerPage (int perPage)
    {
        this.perPage = perPage;
    }
    public void setTotalCount (int totalCount)
    {
        this.totalCount = totalCount;
    }
    public void setCurrentCount (int currentCount)
    {
        this.currentCount = currentCount;
    }
    public void setMatchCount (int matchCount)
    {
        this.matchCount = matchCount;
    }
    public void setNaturalGasData(NaturalGasData[] naturalGasData)
    {
        this.naturalGasData = naturalGasData;
    }
}


