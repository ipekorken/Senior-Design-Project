package com.example.pc.deepmakeupkiller;

import android.util.Log;

public class Urun {
    private String rujImg,Renk,ad,marka;
    private Long Fiyat;
    public Urun(){}
    public Urun(String rujImg, String marka,String Renk,String ad,Long Fiyat){
        this.ad=ad;
        this.Fiyat=Fiyat;
        this.rujImg=rujImg;
        this.Renk=Renk;
        this.marka=marka;
    }

    public String getRujImg() {
        return rujImg;
    }

    public void setRujImg(String rujImg) {
        this.rujImg = rujImg;
    }

    public String getRenk() {
        return Renk;
    }

    public void setRenk(String renk) {
        Renk = renk;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Long getFiyat() {
        return Fiyat;
    }

    public void setFiyat(Long fiyat) {
        Fiyat = fiyat;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }
}
