package com.luce.carrotmarket.domain.orders;

import com.luce.carrotmarket.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Orders extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(length = 8, nullable = false)
    private String date;

    @Column(nullable = false)
    private String saleUsrID;

    @Column(nullable = false)
    private String ctgCD;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String contents;
    private Integer amount;
    private String regUsrID;
    private String chgUsrID;

    @Builder
    public Orders(String date, String saleUsrID, String ctgCD,
                  String title, String contents, Integer amount,
                  String regUsrID, String chgUsrID) {
        this.date = date;
        this.saleUsrID = saleUsrID;
        this.ctgCD = ctgCD;
        this.title = title;
        this.contents = contents;
        this.amount = amount;
        this.regUsrID = regUsrID;
        this.chgUsrID = chgUsrID;
    }


}
