package com.example.domain;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "orders")
public class Order extends BaseEntity<Long> {

	private static final long serialVersionUID = 3050601946744069117L;

	public enum States {
		UNPAID, // 待支付
		WAITING_FOR_RECEIVE, // 待收货
		DONE // 结束
	}

	public enum Events {
		PAY, // 支付
		RECEIVE // 收货
	}

	private States states;

	private Events events;
}
