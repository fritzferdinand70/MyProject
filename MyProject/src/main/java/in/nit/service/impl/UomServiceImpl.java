package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUomDao;
import in.nit.model.Uom;
import in.nit.service.IUomService;

@Service
public class UomServiceImpl implements IUomService {

	@Autowired
	private IUomDao dao;
	
	@Transactional
	@Override
	public Integer saveUom(Uom u) {
		return dao.saveUom(u);
	}

	@Transactional
	@Override
	public void updateUom(Uom u) {
		dao.updateUom(u);
	}

	@Transactional
	@Override
	public void deleteUom(Integer id) {
		dao.deleteUom(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Uom getOneUom(Integer id) {
		return dao.getOneUom(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Uom> getAllUoms() {
		return dao.getAllUoms();
	}

}
