package com.codecool.web.model;

import java.io.Serializable;
import java.sql.*;

public class Assignment implements Serializable {


    public String name;
    public String imgsrc;
    public String about;
    public String about_data;
    public String origin;
    public String origin_data;
    public String spread;
    public String spread_data;

    public Assignment(String imgsrc, String name, String about, String about_data, String origin, String origin_data, String spread, String spread_data){
        this.name = name;
        this.imgsrc = imgsrc;
        this.about = about;
        this.about_data = about_data;
        this.origin = origin;
        this.origin_data = origin_data;
        this.spread = spread;
        this.spread_data = spread_data;
    }

    public String getName() {
        return name;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public String getAbout() {
        return about;
    }

    public String getAbout_data() {
        return about_data;
    }

    public String getOrigin() {
        return origin;
    }

    public String getOrigin_data() {
        return origin_data;
    }

    public String getSpread() {
        return spread;
    }

    public String getSpread_data() {
        return spread_data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public void setAbout_data(String about_data) {
        this.about_data = about_data;
    }

    public void setOrigin_data(String origin_data) {
        this.origin_data = origin_data;
    }

    public void setSpread_data(String spread_data) {
        this.spread_data = spread_data;
    }
}
