package com.seu.darknightsoul.Model;

import java.io.Serializable;

public class InfoList implements Serializable {
    String InfoName;
    Integer InfoImg;
    String infoDtl;

    public InfoList(String infoName, Integer infoImg, String infoDtl) {
       this.InfoName = infoName;
       this.InfoImg = infoImg;
        this.infoDtl = infoDtl;
    }

    public String getInfoName() {
        return InfoName;
    }

    public Integer getInfoImg() {
        return InfoImg;
    }

    public String getInfoDtl() {
        return infoDtl;
    }
}
