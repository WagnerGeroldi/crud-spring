package com.wagner.demo.entities.enums;

public enum OrderStatus {

	AGUARDANDO_PAGAMENTO(1), PAGO(2), ENVIADO(3), ENTREGUE(4), CANCELADO(5);

	Integer code;

	OrderStatus(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static OrderStatus valueOf(Integer code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			} 
		}
		throw new IllegalArgumentException("Status do pedido inválido");
	}

}
