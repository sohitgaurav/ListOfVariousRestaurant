package com.geekster.Restaurant.repository;

import com.geekster.Restaurant.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantDao {

    private List<Restaurant> restaurantList;
    public RestaurantDao(){
        restaurantList= new ArrayList<>();
        restaurantList.add(new Restaurant("0","food court","gaya","12"));
    }
    public List<Restaurant> getAllRestaurantFromDataSource(){
        return restaurantList;
    }
    public boolean save(Restaurant restaurant){
        restaurantList.add(restaurant);
        return true;
    }
    public boolean remove(Restaurant restaurant){
        restaurantList.remove(restaurant);
        return true;
    }
    public boolean update(String id , String restaurantName){
        boolean updateStatus=false;
        for(Restaurant restaurant : restaurantList){
            if(restaurant.getId().equals(id)){

                remove(restaurant);

                restaurant.setRestaurantName(restaurantName);
                save(restaurant);
                return true;
            }
        }
        return false;
    }
}
