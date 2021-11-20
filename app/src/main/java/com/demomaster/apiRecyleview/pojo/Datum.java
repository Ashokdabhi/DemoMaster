
package com.demomaster.apiRecyleview.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("year")
    @Expose
    public Integer year;
    @SerializedName("color")
    @Expose
    public String color;
    @SerializedName("pantone_value")
    @Expose
    public String pantoneValue;

}
