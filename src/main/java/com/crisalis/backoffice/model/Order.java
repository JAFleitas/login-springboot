package com.crisalis.backoffice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orderProduct")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1,
            initialValue = 0
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long id;

    private String description;
    private Date dateCreated;

    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name="customerFk")
    private Customer customer;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE

    )
    private Set<OrderDetail> orderDetails = new HashSet<>();
}
