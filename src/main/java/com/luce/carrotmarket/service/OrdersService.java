package com.luce.carrotmarket.service;

import com.luce.carrotmarket.domain.orders.Orders;
import com.luce.carrotmarket.domain.orders.OrdersRepository;
import com.luce.carrotmarket.web.dto.OrdersListResponseDto;
import com.luce.carrotmarket.web.dto.OrdersResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    @Transactional(readOnly = true)
    public OrdersResponseDto findById(Long seq) {
        Orders entity = ordersRepository.findById(seq).orElseThrow(() -> new IllegalArgumentException("해당 중고거래 내역이 없습니다. Seq=" + seq));

        return new OrdersResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<OrdersListResponseDto> findAllDesc() {
        return ordersRepository.findAllDesc().stream()
                .map(OrdersListResponseDto::new)
                .collect(Collectors.toList());
    }
}
