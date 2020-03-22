package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IWhUserTypeDao;
import in.nit.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveWhUserType(WhUserType wh) {
		return (Integer)ht.save(wh);
	}

	@Override
	public void updateWhUserType(WhUserType wh) {
		ht.update(wh);
	}

	@Override
	public void deletewhUserType(Integer whId) {
		ht.delete(new WhUserType(whId));
	}

	@Override
	public WhUserType getOneWhUserType(Integer whId) {
		return ht.get(WhUserType.class, whId);
	}

	@Override
	public List<WhUserType> getAllWhUserTypes() {
		return ht.loadAll(WhUserType.class);
	}

}
