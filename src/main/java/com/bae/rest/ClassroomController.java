package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.bae.business.service.ClassroomService;

@Path("classrooms")
public class ClassroomController {
	@Inject
	private ClassroomService classroomService;
	
	@GET
	@Path("getAllClassrooms")
	public String getAllClassrooms() {
		return classroomService.getAllClassrooms();
	}
	
	@POST
	@Path("createClassroom")
	@Produces({ "application/json" })
	public String createClassroom(String classroom) {
		return classroomService.createClassroom(classroom);
	}
}
