package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.bae.persistence.domain.Classroom;
import com.bae.util.JSONUtil;

@Alternative
public class ClassroomMapRepo implements ClassroomRepository {
	
	@Inject
	private JSONUtil util;

	@Inject
	Map<Integer, Classroom> classroomMap;

	@Override
	public String createClassroom(String classroom) {
		Classroom cr = util.getObjectForJSON(classroom, Classroom.class);
		classroomMap.put(cr.getId(), cr);
		return util.messageToJSON("Created classroom");
	}

	@Override
	public String getAllClassrooms() {
		String result = "";
		for (Classroom c : classroomMap.values()) {
			result += util.getJSONForObject(c) + "\n";
		}
		return util.messageToJSON(result);
	}

	@Override
	public String getAClassroom(int id) {
		return util.getJSONForObject(classroomMap.get(id));
	}

	@Override
	public String updateClassroom(int id, String classroom) {
		Classroom newCR = util.getObjectForJSON(classroom, Classroom.class);
		classroomMap.replace(id, newCR);
		return util.messageToJSON("Updated classroom");
	}

	@Override
	public String deleteClassroom(int id) {
		if (classroomMap.get(id) != null) {
			classroomMap.remove(id);
			return util.messageToJSON("Deleted classroom");
		}
		return util.messageToJSON("No classroom to delete");
	}

}
