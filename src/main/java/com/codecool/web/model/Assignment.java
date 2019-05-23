package com.codecool.web.model;

import java.util.Objects;

public class Assignment extends AbstractModel {


    public String name;
    public String imgsrc;
    public String about;
    public String origin;
    public String spread;

    public Assignment(int id, String name, String imgsrc, String about, String origin, String spread){
        super(id);
        this.name = name;
        this.imgsrc = imgsrc;
        this.about = about;
        this.origin = origin;
        this.spread = spread;
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

    public String getOrigin() {
        return origin;
    }

    public String getSpread() {
        return spread;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Assignment ass = (Assignment) o;
        return Objects.equals(name, ass.name) &&
                Objects.equals(imgsrc, ass.imgsrc) &&
                Objects.equals(about, ass.about) &&
                Objects.equals(origin, ass.origin) &&
                Objects.equals(spread, ass.spread);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, imgsrc, about, origin, spread);
    }
}
