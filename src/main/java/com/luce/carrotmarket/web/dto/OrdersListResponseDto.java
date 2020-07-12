package com.luce.carrotmarket.web.dto;

import com.luce.carrotmarket.domain.orders.Orders;
import lombok.Getter;

@Getter
public class OrdersListResponseDto {

    private Long seq;
    private String date;
    private String salusrid;
    private String ctgCD;
    private String title;
    private String contents;
    private Integer amount;
    private String createusrid;
    private String modifiedusrid;

    public OrdersListResponseDto(Orders entity) {
        this.seq = entity.getSeq();
        this.date = entity.getDate();
        this.salusrid = entity.getSalusrid();
        this.ctgCD = entity.getCtgCD();
        this.contents = entity.getContents();
        this.amount = entity.getAmount();
        this.createusrid = entity.getCreateusrid();
        this.modifiedusrid = entity.getModifiedusrid();
    }
}
