package com.project.flygifttest;

/**
 * @author suzhuning
 * @date 2017/3/7.
 * Description:
 */
public class DataEntity {

    private int imgRes;
    private String name;
    private String location;
    private String college;
    private String year;

    public DataEntity() {
    }

    public DataEntity(int imgRes, String name, String location, String college, String year) {
        this.imgRes = imgRes;
        this.name = name;
        this.location = location;
        this.college = college;
        this.year = year;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
