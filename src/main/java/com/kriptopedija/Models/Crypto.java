package com.kriptopedija.Models;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Crypto {
    @Id
    private String name;
    @Column(length = 5)
    private String code;
    private String image;
    private Double price;
    private Integer circulatingSupply;
    private String website;
    private Boolean minable;
    private String algorithm;
}
