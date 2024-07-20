package com.proyect.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

	private int id;
	private String plan;
	private String status;
	private String payment_method;
	private String term;
}
