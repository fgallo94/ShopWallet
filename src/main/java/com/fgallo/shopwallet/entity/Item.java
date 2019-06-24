package com.fgallo.shopwallet.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internalCode;
    private String code;
    private String description;
    private BigDecimal price;
    @JsonBackReference
    @ManyToOne
    private Category category;

}


