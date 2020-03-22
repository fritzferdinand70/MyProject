package in.nit.service;

import java.util.List;

import in.nit.model.WhUserType;

public interface IWhUserTypeService {

	Integer saveWhUserType(WhUserType wh);
	void updateWhUserType(WhUserType wh);
	void deletewhUserType(Integer whId);
	WhUserType getOneWhUserType(Integer whId);
	List<WhUserType> getAllWhUserTypes();
}
