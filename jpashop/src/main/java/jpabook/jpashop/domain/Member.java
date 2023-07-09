package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeaha on 2023/07/09
 */
@Getter
@Setter
@Entity
public class Member {
    
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
    
    @Embedded
    private Address address;
    
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
    
}
