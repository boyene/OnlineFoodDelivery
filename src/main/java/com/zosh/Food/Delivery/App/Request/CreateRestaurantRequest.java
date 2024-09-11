package com.zosh.Food.Delivery.App.Request;

import com.zosh.Food.Delivery.App.model.Address;
import com.zosh.Food.Delivery.App.model.ContactInformation;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


import java.util.List;

@Data
public class CreateRestaurantRequest {


    private Long id;
    private String name;
    private String description;
    private String cuisineType;
    private Address address;
    private ContactInformation contactInformation;
    private String openingHours;
   private List<String> images;



}
