package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Trainee;
import com.bae.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepo implements TraineeRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	@Override
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee t = util.getObjectForJSON(trainee, Trainee.class);
		manager.persist(t);
		return util.messageToJSON("Created trainee");
	}

	@Override
	public String getAllTrainees() {
		return util.getJSONForObject(manager.createQuery("SELECT t FROM Trainee t", Trainee.class).getResultList());
	}

	@Override
	public String getATrainee(int id) {
		return util.getJSONForObject(manager.find(Trainee.class, id));
	}

	@Override
	@Transactional(REQUIRED)
	public String updateTrainee(int id, String trainee) {
		Trainee newt = util.getObjectForJSON(trainee, Trainee.class);
		Trainee oldt = util.getObjectForJSON(getATrainee(id),Trainee.class);
		
		if(getATrainee(id) != null) {
			
			oldt.setName(newt.getName());
			manager.merge(oldt);
			
			return util.messageToJSON("Trainee updated");
		}
		return util.messageToJSON("No trainee to update");
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteTrainee(int id) {
		if(manager.find(Trainee.class, id) != null) {
			manager.remove(id);
			return util.messageToJSON("Deleted Trainee");
		}
		return util.messageToJSON("No trainee to delete");

	}

	@Override
	public String setClassroom(int tID, int cID) {
		// TODO Auto-generated method stub
		return null;
	}

}
