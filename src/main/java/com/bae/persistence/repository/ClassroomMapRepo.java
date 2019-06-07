package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional(SUPPORTS)
@Default
public class ClassroomMapRepo implements ClassroomRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Override
	public String createClassroom(String classroom) {
		// TODO Auto-generated method stub
		return null;
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
