package com.bae.MapTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.bae.persistence.domain.Classroom;
import com.bae.persistence.repository.ClassroomMapRepo;
import com.bae.util.JSONUtil;

public class ClassroomServiceTest {
	private JSONUtil util;
	private ClassroomMapRepo repo;
	
	Classroom c1;
	Classroom c2;
	Classroom c3;
	
	Classroom c1new;
	
	@Before
	public void setup() {
		util = new JSONUtil();
		repo = new ClassroomMapRepo();
		
		c1 = new Classroom(1, "Chester");
		c2 = new Classroom(2, "Matt");
		c3 = new Classroom(3, "Tom");
		
		c1new = new Classroom(1, "Jordan");		
	}
	
	@Test
	public void addClassroomTest() {
		repo.createClassroom(util.getJSONForObject(c1));
		
		assertEquals(util.getJSONForObject(c1), repo.getAClassroom(c1.getId()));
	}
	
	@Test
	public void add2ClassroomsTest() {
		repo.createClassroom(util.getJSONForObject(c1));
		repo.createClassroom(util.getJSONForObject(c2));
		
		assertEquals(util.getJSONForObject(c1)+ "\n" + util.getJSONForObject(c2) + "\n", repo.getAllClassrooms());
	}
	
	@Test
	public void updateClassroomTest() {
		repo.createClassroom(util.getJSONForObject(c1));
		repo.createClassroom(util.getJSONForObject(c1new));
		
		repo.updateClassroom(c1.getId(), util.getJSONForObject(c1new));
		
		assertEquals(c1new.getTrainer(), util.getObjectForJSON(repo.getAClassroom(c1.getId()), Classroom.class).getTrainer());
	}
	
	@Test
	public void deleteClassroom() {
		repo.createClassroom(util.getJSONForObject(c1));
		
		assertEquals(util.messageToJSON("Deleted classroom"),repo.deleteClassroom(c1.getId()));
		
		//assertEquals(null, repo.getAClassroom(c1.getId()));
	}
}
