package com.luce.carrotmarket.web.dto;

import com.luce.carrotmarket.domain.orders.Orders;
import lombok.Getter;

@Getter
public class OrdersListResponseDto {

    private Long seq;
    private String date;
    private String saleUsrID;
    private String ctgCD;
    private String title;
    private String contents;
    private Integer amount;
    private String regUsrID;
    private String chgUsrID;

    public OrdersListResponseDto(Orders entity) {
        this.seq = entity.getSeq();
        this.date = entity.getDate();
        this.saleUsrID = entity.getSaleUsrID();
        this.ctgCD = entity.getCtgCD();
        this.contents = entity.getContents();
        this.amount = entity.getAmount();
        this.regUsrID = entity.getRegUsrID();
        this.chgUsrID = entity.getChgUsrID();
    }
}
