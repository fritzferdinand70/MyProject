package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IWhUserTypeDao;
import in.nit.model.WhUserType;
import in.nit.service.IWhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	@Autowired
	private IWhUserTypeDao dao;
	
	@Transactional
	@Override
	public Integer saveWhUserType(WhUserType wh) {
		return dao.saveWhUserType(wh);
	}

	@Transactional
	@Override
	public void updateWhUserType(WhUserType wh) {
		dao.updateWhUserType(wh);
	}

	@Transactional
	@Override
	public void deletewhUserType(Integer whId) {
		dao.deletewhUserType(whId);
	}

	@Transactional(readOnly = true)
	@Override
	public WhUserType getOneWhUserType(Integer whId) {
		return dao.getOneWhUserType(whId);
	}

	@Transactional(readOnly = true)
	@Override
	public List<WhUserType> getAllWhUserTypes() {
		return dao.getAllWhUserTypes();
	}

}
