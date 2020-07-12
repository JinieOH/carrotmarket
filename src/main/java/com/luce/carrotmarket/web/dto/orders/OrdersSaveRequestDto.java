package com.luce.carrotmarket.web.dto.orders;

import com.luce.carrotmarket.domain.orders.Orders;
import com.luce.carrotmarket.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrdersSaveRequestDto {
    private String date;
    private String salusrid;
    private String ctgCD;
    private String title;
    private String contents;
    private Integer amount;
    private String createusrid;

    @Builder
    public OrdersSaveRequestDto(String date, String salusrid, String ctgCD, String title, String contents, Integer amount, String createusrid) {
        this.date = date;
        this.salusrid = salusrid;
        this.ctgCD = ctgCD;
        this.title = title;
        this.contents = contents;
        this.amount = amount;
        this.createusrid = createusrid;
    }

    public Orders toEntity() {
        return Orders.builder()
                .date(date)
                .salusrid(salusrid)
                .ctgCD(ctgCD)
                .title(title)
                .contents(contents)
                .amount(amount)
                .createusrid(createusrid)
                .build();
    }

}