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
    private String salusrid;

    @Column(nullable = false)
    private String ctgCD;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String contents;
    private Integer amount;
    private String createusrid;
    private String modifiedusrid;

    @Builder
    public Orders(String date, String salusrid, String ctgCD,
                  String title, String contents, Integer amount,
                  String createusrid, String modifiedusrid) {
        this.date = date;
        this.salusrid = salusrid;
        this.ctgCD = ctgCD;
        this.title = title;
        this.contents = contents;
        this.amount = amount;
        this.createusrid = createusrid;
        this.modifiedusrid = modifiedusrid;
    }


}
