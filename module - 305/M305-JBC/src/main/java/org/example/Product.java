package org.example;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private String productCode;

    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private Integer quantityInStock;
    private Double buyPrice;
    private Double MSRP;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails;

    // Getters and Setters
}
