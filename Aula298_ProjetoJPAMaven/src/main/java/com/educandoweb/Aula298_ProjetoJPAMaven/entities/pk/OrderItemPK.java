package com.educandoweb.Aula298_ProjetoJPAMaven.entities.pk;

import com.educandoweb.Aula298_ProjetoJPAMaven.entities.Order;
import com.educandoweb.Aula298_ProjetoJPAMaven.entities.Product;

public class OrderItemPK {

	private Order order;
	private Product product;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
