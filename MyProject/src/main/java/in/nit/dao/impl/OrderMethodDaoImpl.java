package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IOrderMethodDao;
import in.nit.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveOrderMethod(OrderMethod om) {
		return (Integer)ht.save(om);
	}

	@Override
	public void updateOrderMethod(OrderMethod om) {
		ht.update(om);
	}

	@Override
	public void deleteOrderMethod(Integer orderId) {
		ht.delete(new OrderMethod(orderId));
	}

	@Override
	public OrderMethod getOneOrderMethod(Integer orderId) {
		return ht.get(OrderMethod.class, orderId);
	}

	@Override
	public List<OrderMethod> getAllOrderMethods() {
		return ht.loadAll(OrderMethod.class);
	}

}
