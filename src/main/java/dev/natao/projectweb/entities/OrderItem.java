package dev.natao.projectweb.entities;

import java.io.Serializable;
import java.util.Objects;

import dev.natao.projectweb.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId // For compost ID
	private OrderItemPK id;
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {}

	public OrderItem(Order  order, Product product, Integer quantity, Double price) {
		super();
		id.setOrder(order); // .setOrder from OrderItemPK
		id.setProduct(product); // .setProduct from OrderItemPK 
		this.quantity = quantity;
		this.price = price;
	}
	
	// OrderItemPK getters and setters
	public Order gerOrder() {
		return id.getOrder(); // from OrderItemPK
	}
	
	public void setOrder(Order order) {
		id.setOrder(order); // from OrderItemPK
	}
	
	public Product getProduct() {
		return id.getProduct(); // from OrderItemPK
	}
	
	public void setProduct(Product product) {
		id.setProduct(product); // from OrderItemPK
	}
	
	
	// OrderItem getters and setters
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
}
