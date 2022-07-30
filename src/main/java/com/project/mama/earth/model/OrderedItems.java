package com.project.mama.earth.model;

import com.project.mama.earth.dto.CartDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ordered_items")
public class OrderedItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
    private String username;
    private String productName;
    private Integer quantity;
    private Long price;

    public OrderedItems(CartDto cartDto) {
        this.username = cartDto.getUsername();
        this.productName = cartDto.getProductName();
        this.quantity = cartDto.getQuantity();
        this.price = cartDto.getPrice();
    }
}
