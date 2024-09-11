package com.zosh.Food.Delivery.App.Repository;

import com.zosh.Food.Delivery.App.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
