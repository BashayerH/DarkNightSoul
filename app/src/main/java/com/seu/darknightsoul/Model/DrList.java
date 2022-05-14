package com.seu.darknightsoul.Model;

import java.io.Serializable;

public class DrList implements Serializable {

    String drName;
    Integer drImg;
    String drDtl;
    String drSpecial;
    String drLang;

    public DrList(String drName, Integer drImg, String drDtl, String drSpecial, String drLang) {
        this.drName = drName;
        this.drImg = drImg;
        this.drDtl = drDtl;
        this.drSpecial = drSpecial;
        this.drLang = drLang;
    }

    public String getDrName() {
        return drName;
    }

    public Integer getDrImg() {
        return drImg;
    }

    public String getDrDtl() {
        return drDtl;
    }

    public String getDrSpecial() {
        return drSpecial;
    }

    public String getDrLang() {
        return drLang;
    }
}
