package com.example.suryasolanki.matka.Java;

/**
 * Created by surya.solanki on 10-12-2016.
 */

public class BidData {

    private String bidValue;
    private int thumbNail;
    public static float amount;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private int type;

    public BidData() {
    }

    public BidData(String bidValue, int thumbNail) {
        this.bidValue = bidValue;
        this.thumbNail = thumbNail;
    }

    public BidData(String bidValue) {
        this.bidValue = bidValue;
    }

    public BidData(String bidValue, int thumbNail, int type) {
        this.bidValue = bidValue;
        this.thumbNail = thumbNail;
        this.type = type;
    }

    public String getBidValue() {
        return bidValue;
    }

    public void setBidValue(String bidValue) {
        this.bidValue = bidValue;
    }

    public int getThumbNail() {
        return thumbNail;
    }

    public void setThumbNail(int thumbNail) {
        this.thumbNail = thumbNail;
    }
}
