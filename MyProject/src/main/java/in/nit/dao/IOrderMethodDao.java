package in.nit.dao;

import java.util.List;

import in.nit.model.OrderMethod;

public interface IOrderMethodDao {

	Integer saveOrderMethod(OrderMethod om);
	void updateOrderMethod(OrderMethod om);
	void deleteOrderMethod(Integer orderId);
	OrderMethod getOneOrderMethod(Integer orderId);
	List<OrderMethod> getAllOrderMethods();
}
