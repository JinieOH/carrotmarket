package com.luce.carrotmarket.web;

import com.luce.carrotmarket.web.dto.OrdersListResponseDto;
import com.luce.carrotmarket.web.dto.OrdersResponseDto;
import com.luce.carrotmarket.service.OrdersService;
import com.luce.carrotmarket.web.dto.orders.OrdersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrdersApiController {

    private final OrdersService ordersService;

    @GetMapping("/api/order")
    public String index(Model model) {
        return "OrdersApiController";
    }

    @GetMapping("/api/order/v1/detailInfo/{seq}")
    public OrdersResponseDto findById(@PathVariable Long seq) {
        return ordersService.findById(seq);
    }

    @GetMapping("/api/order/v1/list")
    public List<OrdersListResponseDto> findAllDesc() {
        return ordersService.findAllDesc();
    }

    @PostMapping("/api/order/v1/orders")
    public Long save(@RequestBody OrdersSaveRequestDto requestDto) {
        return ordersService.save(requestDto);
    }

}
