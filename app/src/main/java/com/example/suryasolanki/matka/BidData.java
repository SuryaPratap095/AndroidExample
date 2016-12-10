package com.example.suryasolanki.matka;

/**
 * Created by surya.solanki on 10-12-2016.
 */

public class BidData {

    private String bidValue;
    private int thumbNail;

    public BidData() {
    }

    public BidData(String bidValue, int thumbNail) {
        this.bidValue = bidValue;
        this.thumbNail = thumbNail;
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
