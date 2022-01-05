package com.example.shoppingcart.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @Setter(AccessLevel.PROTECTED)
    private String email;

    @OneToOne
    @Setter(AccessLevel.PROTECTED)
    private CreditCard creditCard;

    private String firstName;
    private String lastName;
}
