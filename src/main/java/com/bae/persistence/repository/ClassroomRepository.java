package com.bae.persistence.repository;

public interface ClassroomRepository {

	String createClassroom(String classroom);
	
	String getAllClassrooms();
	
	String getAClassroom(int id);
	
	String updateClassroom(int id, String classroom);
	
	String deleteClassroom(int id);
	
}
