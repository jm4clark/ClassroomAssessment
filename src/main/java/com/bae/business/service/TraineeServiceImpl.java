package com.bae.business.service;

import javax.inject.Inject;
import com.bae.persistence.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService{

	@Inject
	private TraineeRepository repo;
	
	@Override
	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	@Override
	public String getATrainee(int id) {
		return repo.getATrainee(id);
	}

	@Override
	public String createTrainee(String trainee) {
		return repo.createTrainee(trainee);
	}

	@Override
	public String deleteTrainee(int id) {
		return repo.deleteTrainee(id);
	}

	@Override
	public String updateTrainee(int id, String trainee) {
		return repo.updateTrainee(id, trainee);
	}

}
