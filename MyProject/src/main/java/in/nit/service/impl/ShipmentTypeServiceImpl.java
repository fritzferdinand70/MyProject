package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	IShipmentTypeDao dao;
	
	@Transactional
	@Override
	public Integer saveShipmentType(ShipmentType ob) {
		return dao.saveShipmentType(ob);
	}
	@Transactional
	@Override
	public void deleteShipmentType(Integer sid) {
		dao.deleteShipmentType(sid);
	}
	@Transactional
	@Override
	public void updateShipmentType(ShipmentType ob) {
		dao.updateShipmentType(ob);
	}
	@Transactional(readOnly = true)
	@Override
	public ShipmentType getOneShipmentType(Integer sid) {
		return dao.getOneShipmentType(sid);
	}
	@Transactional(readOnly = true)
	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		return dao.getAllShipmentTypes();
	}

}
