package com.geekster.Restaurant.service;

import com.geekster.Restaurant.model.Restaurant;
import com.geekster.Restaurant.repository.RestaurantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantDao restaurantDao;
    public List< Restaurant> getAllRestaurant(){
       return restaurantDao.getAllRestaurantFromDataSource();
    }
    public String addRestaurant(Restaurant restaurant){

        boolean insertionRestaurant=restaurantDao.save(restaurant);
        if(insertionRestaurant){
            return "restaurant added Successfully";
        }
        else{
            return " failed to add Restaurant";
        }
    }

   public Restaurant getRestaurantBasedOnId(String id){
        List<Restaurant> restaurantListRightNow= restaurantDao.getAllRestaurantFromDataSource();

        for(Restaurant restaurant : restaurantListRightNow)
            if(restaurant.getId().equals(id)){
                return restaurant;
       }
       return null;

   }
   public String removeRestaurantById(String id){
        boolean deleteResponse=false;
        String status;
        if(id!=null) {
            List<Restaurant> restaurantListRightNow = restaurantDao.getAllRestaurantFromDataSource();

            for (Restaurant restaurant : restaurantListRightNow) {
                if (restaurant.getId().equals(id)) {
                    deleteResponse = restaurantDao.remove(restaurant);
                    if (deleteResponse) {
                        status = "restaurant wit id " + id + " was deleted";
                    } else {
                        status = "restaurant wit id " + id + " was not deleted";
                    }
                    return status;

                }


            }
            return "restaurant with id " + id + " does not exist";
        }
        else{
            return "id cant not accept null id";
        }
   }
   public String updateRestaurantNameById(String id , String restaurantName){
        boolean updateStatus=restaurantDao.update(id,restaurantName);
        if(updateStatus){
            return "restaurant with id "+id+" was updated";
        }
        else{
            return "restaurant with id "+id+" was not updated";
        }
   }


}
