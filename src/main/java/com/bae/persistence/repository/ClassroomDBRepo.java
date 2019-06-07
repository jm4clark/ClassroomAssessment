package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

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
	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom c = util.getObjectForJSON(classroom, Classroom.class);
		manager.persist(c);
		return util.messageToJSON("Classroom added");
	}

	@Override
	public String getAllClassrooms() {
		return util.getJSONForObject(manager.createQuery("SELECT c FROM Classroom c", Classroom.class).getResultList());
	}

	@Override
	public String getAClassroom(int id) {
		return util.getJSONForObject(manager.find(Classroom.class, id));
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public String updateClassroom(int id, String classroom) {
		Classroom newcr = util.getObjectForJSON(classroom, Classroom.class);
		Classroom oldcr = util.getObjectForJSON(getAClassroom(id),Classroom.class);
		
		if(getAClassroom(id) != null) {
			
			oldcr.setTrainer(newcr.getTrainer());
			oldcr.setTrainees(newcr.getTrainees());
			manager.merge(oldcr);
			
			return util.messageToJSON("Classroom updated");
		}
		return util.messageToJSON("No classroom to update");
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public String deleteClassroom(int id) {
		if(manager.find(Classroom.class, id) != null) {
			manager.remove(id);
			return util.messageToJSON("Deleted classroom");
		}
		return util.messageToJSON("No classroom to delete");
	}

}
