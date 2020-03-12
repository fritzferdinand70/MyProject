package in.nit.service;

import java.util.List;

import in.nit.model.Uom;

public interface IUomService {

	Integer saveUom(Uom u);
	void updateUom(Uom u);
	void deleteUom(Integer id);
	Uom getOneUom(Integer id);
	List<Uom> getAllUoms();
}
