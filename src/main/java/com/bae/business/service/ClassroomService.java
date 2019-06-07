package com.bae.business.service;

public interface ClassroomService {
	
	String getAllClassrooms();
	
	String getAClassroom(int id);
	
	String createClassroom(String classroom);
	
	String deleteClassroom(int id);
	
	String updateClassroom(int id, String classroom);

}
