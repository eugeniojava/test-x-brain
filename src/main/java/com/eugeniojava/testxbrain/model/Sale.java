package com.eugeniojava.testxbrain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "sale_table")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "sale_date_of_sale")
    private LocalDate dateOfSale;

    @Positive
    @Column(name = "sale_amount")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    public Sale(LocalDate dateOfSale, @Positive BigDecimal amount,
                Seller seller) {
        this.dateOfSale = dateOfSale;
        this.amount = amount;
        this.seller = seller;
    }
}
