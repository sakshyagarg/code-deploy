package com.project.mama.earth.dto;

import com.project.mama.earth.model.OrderedItems;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderedItemsDto {
    private Long orderId;
    private String productName;
    private Integer quantity;
    private Long price;

    public OrderedItemsDto(OrderedItems orderedItems) {
        this.orderId = orderedItems.getOrderId();
        this.productName = orderedItems.getProductName();
        this.quantity = orderedItems.getQuantity();
        this.price = orderedItems.getPrice();
    }
}
