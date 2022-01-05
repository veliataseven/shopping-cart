package com.example.shoppingcart.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {

    @Id
    @Setter(AccessLevel.PROTECTED)
    private long creditCardNumber;
}
