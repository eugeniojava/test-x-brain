package com.eugeniojava.testxbrain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "seller_table")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Long id;

    @NotBlank
    @Column(name = "seller_name")
    private String name;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Sale> sales;

    public Seller(@NotBlank String name) {
        this.name = name;
    }
}
