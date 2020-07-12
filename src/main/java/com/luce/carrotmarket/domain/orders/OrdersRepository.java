package com.luce.carrotmarket.domain.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT p FROM Orders p ORDER BY p.seq DESC")
    List<Orders> findAllDesc();


}