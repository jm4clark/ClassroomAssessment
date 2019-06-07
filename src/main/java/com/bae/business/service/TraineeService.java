package com.bae.business.service;

public interface TraineeService {
	String getAllTrainees();

	String getATrainee(int id);

	String createTrainee(String trainee);

	String deleteTrainee(int id);

	String updateTrainee(int id, String trainee);
}
