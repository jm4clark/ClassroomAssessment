package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistence.repository.ClassroomRepository;

public class ClassroomServiceImpl implements ClassroomService{

	@Inject
	private ClassroomRepository repo;
	
	@Override
	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	@Override
	public String getAClassroom(int id) {
		return repo.getAClassroom(id);
	}
	
	@Override
	public String createClassroom(String classroom) {
		return repo.createClassroom(classroom);
	}

	@Override
	public String deleteClassroom(int id) {
		return repo.deleteClassroom(id);
	}

	@Override
	public String updateClassroom(int id, String classroom) {
		return repo.updateClassroom(id, classroom);
	}

	public ClassroomRepository getRepo() {
		return repo;
	}

	public void setRepo(ClassroomRepository repo) {
		this.repo = repo;
	}

}
