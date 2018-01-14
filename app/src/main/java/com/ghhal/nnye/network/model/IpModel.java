package com.ghhal.nnye.network.model;

import com.google.gson.annotations.SerializedName;

public class IpModel {
    private String city;
    @SerializedName("country_code")
    private String countryCode;
    @SerializedName("country_name")
    private String countryName;
    @SerializedName("region_name")
    private String regionName;

    public String getCountryCode() {
        return this.countryCode;
    }

    public String toString() {
        return "IpModel{countryCode='" + this.countryCode + '\'' + ", countryName='" + this.countryName + '\'' + ", regionName='" + this.regionName + '\'' + ", city='" + this.city + '\'' + '}';
    }
}
