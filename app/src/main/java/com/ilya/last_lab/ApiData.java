package com.ilya.last_lab;

import com.google.gson.annotations.SerializedName;


public class ApiData {
    private int id;
    private String name;
    @SerializedName("growth_time")
    private int growthTime;
    @SerializedName("max_harvest")
    private int maxHarvest;
    @SerializedName("size")
    private int size;
    @SerializedName("smoothness")
    private int smoothness;
    @SerializedName("soil_dryness")
    private int soilDryness;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getGrowthTime() {
        return growthTime;
    }
    public void setGrowthTime(int growthTime) {
        this.growthTime = growthTime;
    }
    public int getMaxHarvest() {
        return maxHarvest;
    }
    public void setMaxHarvest(int maxHarvest) {
        this.maxHarvest = maxHarvest;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getSmoothness() {
        return smoothness;
    }
    public void setSmoothness(int smoothness) {
        this.smoothness = smoothness;
    }
    public int getSoilDryness() {
        return soilDryness;
    }
    public void setSoilDryness(int soilDryness) {
        this.soilDryness = soilDryness;
    }
}

