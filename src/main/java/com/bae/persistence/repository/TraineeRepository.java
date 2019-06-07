package com.bae.persistence.repository;

public interface TraineeRepository {
	String createTrainee(String trainee);

	String getAllTrainees();

	String getATrainee(int id);

	String updateTrainee(int id, String trainee);

	String deleteTrainee(int id);
	
	String setClassroom(int tID, int cID);
}
