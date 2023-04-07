package dev.natao.projectweb.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	// Enum constructor
	private OrderStatus(int code) {
		this.code = code;
	}
	
	// Public method that'll return Enum's code
	public int getCode() {
		return this.code;
	}
	
	// Convert numeric value enum value
	public static OrderStatus valueOf(int code) {
		// Return the Enum corresponding id param
		for (OrderStatus status: OrderStatus.values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid order status code.");
	}
}
