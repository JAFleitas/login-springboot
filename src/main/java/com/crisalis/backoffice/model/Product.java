package com.crisalis.backoffice.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1,
            initialValue = 0
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;


    // cuando se hace una relacion bidireccional se utiliza la relacion opuesta a la entidad relacionada
    // ejempo : @OneToMany en Product, y @ManyToOne en OrderDetail.
    /* @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL

    private Set<OrderDetail> orderDetails = new HashSet<>();
    )*/

    /* RELACION MUCHOS A MUCHOS CON MODIFICACIONES EN EL NOMBRE DE LA TABLA
    @ManyToMany
    @JoinTable(
            name = "productCustomerRelationship",
            joinColumns = {
                    @JoinColumn(name = "fkProduct")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "fkCustomer")
            }
    )
    private List<Customer> customerList = new ArrayList<>();*/
}
