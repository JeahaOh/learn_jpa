package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by jeaha on 2023/07/09
 */
@Entity
@Getter
@Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;
    
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
    
    @Embedded
    private Address address;
    
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
