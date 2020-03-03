package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	
	@Autowired
	HibernateTemplate ht;

	@Override
	public Integer saveShipmentType(ShipmentType ob) {
		
		return (Integer)ht.save(ob);
	}

	@Override
	public void deleteShipmentType(Integer sid) {
		ht.delete(new ShipmentType(sid));
	}

	@Override
	public ShipmentType getOneShipmentType(Integer sid) {
		return ht.get(ShipmentType.class, sid);
	}

	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		return ht.loadAll(ShipmentType.class);
	}

	@Override
	public void updateShipmentType(ShipmentType ob) {
		ht.update(ob);
	}

}
