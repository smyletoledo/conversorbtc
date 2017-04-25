package com.devtoledo.conversorbtc.remote.repository;

import com.google.gson.annotations.SerializedName;

/**
 * Created by smyle.toledo on 20/04/2017.
 */

public class PriceList {

    @SerializedName("15m")
    private Double last15m;

    private String symbol;

    private Double last;

    private Double sell;

    private Double buy;

    public Double getLast15m ()
    {
        return last15m;
    }

    public void setLast15m (Double last15m)
    {
        this.last15m = last15m;
    }

    public String getSymbol ()
    {
        return symbol;
    }

    public void setSymbol (String symbol)
    {
        this.symbol = symbol;
    }

    public Double getLast ()
    {
        return last;
    }

    public void setLast (Double last)
    {
        this.last = last;
    }

    public Double getSell ()
    {
        return sell;
    }

    public void setSell (Double sell)
    {
        this.sell = sell;
    }

    public Double getBuy ()
    {
        return buy;
    }

    public void setBuy (Double buy)
    {
        this.buy = buy;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [15m = "+last15m+", symbol = "+symbol+", last = "+last+", sell = "+sell+", buy = "+buy+"]";
    }
}

