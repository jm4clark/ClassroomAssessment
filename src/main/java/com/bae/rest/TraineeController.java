package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
}
