package in.nit.service;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeService {
	Integer saveShipmentType(ShipmentType ob);
	void deleteShipmentType(Integer sid);
	void updateShipmentType(ShipmentType ob);
	ShipmentType getOneShipmentType(Integer sid);
	List<ShipmentType> getAllShipmentTypes();
}
