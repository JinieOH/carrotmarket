package com.luce.carrotmarket.web;

import com.luce.carrotmarket.web.dto.OrdersListResponseDto;
import com.luce.carrotmarket.web.dto.OrdersResponseDto;
import com.luce.carrotmarket.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrdersApiController {

    private final OrdersService ordersService;

    @GetMapping("/order")
    public String index(Model model) {
        return "OrdersApiController";
    }

    @GetMapping("/order/v1/orders/{id}")
    public OrdersResponseDto findById(@PathVariable Long id) {
        return ordersService.findById(id);
    }

    @GetMapping("/api/v1/orders/list")
    public List<OrdersListResponseDto> findAllDesc() {
        return ordersService.findAllDesc();
    }
}
