package in.nit.service;

import java.util.List;

import in.nit.model.OrderMethod;

public interface IOrderMethodService {

	Integer saveOrderMethod(OrderMethod om);
	void updateOrderMethod(OrderMethod om);
	void deleteOrderMethod(Integer orderId);
	OrderMethod getOneOrderMethod(Integer orderId);
	List<OrderMethod> getAllOrderMethods();
}
