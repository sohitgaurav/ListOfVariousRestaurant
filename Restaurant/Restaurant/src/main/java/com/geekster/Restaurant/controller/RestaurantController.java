package com.geekster.Restaurant.controller;

import com.geekster.Restaurant.RestaurantApplication;
import com.geekster.Restaurant.model.Restaurant;
import com.geekster.Restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;


    @GetMapping(value="/getAllRestaurant")
    public List<Restaurant> getAllRestaurant(){
      return  restaurantService.getAllRestaurant();
    }
    @PostMapping(value="/addRestaurant")
    public String addRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.addRestaurant(restaurant);

    }
    @RequestMapping(value="/getRestaurantById/{id}",method=RequestMethod.GET)
    public Restaurant getRestaurantById(@PathVariable String id){
         return restaurantService.getRestaurantBasedOnId(id);
    }
    @DeleteMapping(value="/deleteRestaurantById/{id}")
    public String deleteRestaurantById(@PathVariable String id){
        return restaurantService.removeRestaurantById(id);
    }
    @PutMapping(value="/updateRestaurantById/{id}/{restaurantName}")
    public String updateRestaurantNameById(@PathVariable String id,@PathVariable String restaurantName){
      return   restaurantService.updateRestaurantNameById(id,restaurantName);
    }

}
