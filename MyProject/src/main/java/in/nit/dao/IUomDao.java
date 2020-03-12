package in.nit.dao;

import java.util.List;

import in.nit.model.Uom;

public interface IUomDao {

	Integer saveUom(Uom u);
	void updateUom(Uom u);
	void deleteUom(Integer id);
	Uom getOneUom(Integer id);
	List<Uom> getAllUoms();
}
