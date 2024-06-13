package org.example;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailPK implements Serializable {

    private Long orderNumber;
    private String productCode;

    public OrderDetailPK() {}

    public OrderDetailPK(Long orderNumber, String productCode) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
    }

    // Getters, Setters, equals, and hashCode
}
