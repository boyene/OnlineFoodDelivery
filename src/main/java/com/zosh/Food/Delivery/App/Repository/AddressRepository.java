package com.zosh.Food.Delivery.App.Repository;

import com.zosh.Food.Delivery.App.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
