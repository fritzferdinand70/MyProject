package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IOrderMethodDao;
import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private IOrderMethodDao dao;
	
	@Transactional
	@Override
	public Integer saveOrderMethod(OrderMethod om) {
		return dao.saveOrderMethod(om);
	}

	@Transactional
	@Override
	public void updateOrderMethod(OrderMethod om) {
		dao.updateOrderMethod(om);
	}

	@Transactional
	@Override
	public void deleteOrderMethod(Integer orderId) {
		dao.deleteOrderMethod(orderId);
	}

	@Transactional(readOnly = true)
	@Override
	public OrderMethod getOneOrderMethod(Integer orderId) {
		return dao.getOneOrderMethod(orderId);
	}

	@Transactional(readOnly = true)
	@Override
	public List<OrderMethod> getAllOrderMethods() {
		return dao.getAllOrderMethods();
	}

}
