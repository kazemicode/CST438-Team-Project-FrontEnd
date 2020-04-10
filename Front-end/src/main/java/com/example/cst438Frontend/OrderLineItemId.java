package com.example.cst438Frontend;
import java.io.Serializable;
import java.util.Objects;

/* Source: https://attacomsian.com/blog/spring-data-jpa-composite-primary-key# */

public class OrderLineItemId implements Serializable {
	private Long orderId;
	private Long order_sequence;
	
	public OrderLineItemId() {
		
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLineItemId orderLineItemId = (OrderLineItemId) o;
        return orderId.equals(orderLineItemId.orderId) &&
                order_sequence.equals(orderLineItemId.order_sequence);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(orderId, order_sequence);
    }

}