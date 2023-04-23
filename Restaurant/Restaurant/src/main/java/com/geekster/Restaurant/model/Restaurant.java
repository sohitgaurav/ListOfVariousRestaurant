package com.geekster.Restaurant.model;

public class Restaurant {
    private String id;
    private String restaurantName;
    private String restaurantAddress;

    private String totalStaff;

    public Restaurant(String id, String restaurantName, String restaurantAddress, String totalStaff) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.totalStaff = totalStaff;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getTotalStaff() {
        return totalStaff;
    }

    public void setTotalStaff(String totalStaff) {
        this.totalStaff = totalStaff;
    }
}
