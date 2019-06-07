package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.service.TraineeService;

@Path("trainees")
public class TraineeController {
	@Inject
	private TraineeService traineeService;
	
	@GET
	@Path("getAllTrainees")
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return traineeService.getAllTrainees();
	}
	
	@POST
	@Path("createTrainee")
	@Produces({ "application/json" })
	public String createTrainee(String trainee) {
		return traineeService.createTrainee(trainee);
	}
	
	@Path("deleteTrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") int id) {
		return traineeService.deleteTrainee(id);
	}
	
	@Path("updateClassroom/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(@PathParam("id") int id, String trainee) {
		return traineeService.updateTrainee(id, trainee);
	}
}
