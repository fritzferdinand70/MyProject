package in.nit.dao;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeDao {
	Integer saveShipmentType(ShipmentType ob);
	void deleteShipmentType(Integer sid);
	void updateShipmentType(ShipmentType ob);
	ShipmentType getOneShipmentType(Integer sid);
	List<ShipmentType> getAllShipmentTypes();
}
