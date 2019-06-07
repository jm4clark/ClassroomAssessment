package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	@GET
	@Path("getClassroom/{id}")
	@Produces({ "application/json" })
	public String getAClassroom(@PathParam("id") int id) {
		return classroomService.getAClassroom(id);
	}
	
	
	@POST
	@Path("createClassroom")
	@Produces({ "application/json" })
	public String createClassroom(String classroom) {
		return classroomService.createClassroom(classroom);
	}
	
	@Path("deleteClassroom/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("id") int id) {
		return classroomService.deleteClassroom(id);
	}
	
	@Path("updateClassroom/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateClassroom(@PathParam("id") int id, String classroom) {
		return classroomService.updateClassroom(id, classroom);
	}
}
