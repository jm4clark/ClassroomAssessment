package com.bae.persistence.repository;

import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.bae.persistence.domain.Trainee;
import com.bae.util.JSONUtil;

@Alternative
public class TraineeMapRepo implements TraineeRepository{

	@Inject
	private JSONUtil util;
	
	Map<Integer, Trainee> traineeMap;
	
	@Override
	public String createTrainee(String trainee) {
		Trainee t = util.getObjectForJSON(trainee, Trainee.class);
		traineeMap.put(t.getId(), t);
		return util.messageToJSON("Created trainee");
	}

	@Override
	public String getAllTrainees() {
		String result = "";
		for(Trainee t : traineeMap.values()) {
			result += util.getJSONForObject(t) + "\n";
		}
		return util.messageToJSON(result);
	}

	@Override
	public String getATrainee(int id) {
		return util.getJSONForObject(traineeMap.get(id));
	}

	@Override
	public String updateTrainee(int id, String trainee) {
		Trainee newT = util.getObjectForJSON(trainee, Trainee.class);
		traineeMap.replace(id,  newT);
		return util.messageToJSON("Updated trainee");
	}

	@Override
	public String deleteTrainee(int id) {
		if(traineeMap.get(id) != null) {
			traineeMap.remove(id);
			return util.messageToJSON("Deleted trainee");
		}
		return util.messageToJSON("No trainee to delete");
	}

	@Override
	public String setClassroom(int tID, int cID) {
		// TODO Auto-generated method stub
		return null;
	}

}
