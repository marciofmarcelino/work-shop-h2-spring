package com.marciofmf.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marciofmf.course.entities.OrderItem;
import com.marciofmf.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
