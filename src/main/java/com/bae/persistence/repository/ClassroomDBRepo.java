package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Classroom;
import com.bae.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepo implements ClassroomRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String createClassroom(String classroom) {
		return util.getJSONForObject(manager.createQuery("SELECT a FROM Account a", Classroom.class).getResultList());
	}

	@Override
	public String getAllClassrooms() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAClassroom(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateClassroom(int id, String classroom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteClassroom(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
