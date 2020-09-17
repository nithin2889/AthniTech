package com.athnitech.resources;

import com.athnitech.model.Trainee;
import com.athnitech.services.RegisterService;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterResource {

  private final RegisterService registerService;

  @Autowired
  public RegisterResource(RegisterService registerService) {
    this.registerService = registerService;
  }

  @GetMapping(value = "/getAllTrainees")
  public List<Trainee> getAllTrainees() throws ExecutionException, InterruptedException {
    return registerService.getDocumentSnapshot();
  }

  @PostMapping("register/trainee")
  public long registerTrainee(@RequestBody Trainee trainee) {
    return registerService.registerTrainee(trainee);
  }

  @GET
  @Path("/getTrainee/{id}")
  public Trainee getTraineeById(@PathParam("id") Long id) {
    return null;
  }

  @PUT
  @Path("/updateTrainee")
  public Trainee updateTrainee(@RequestBody Trainee trainee) {
    return null;
  }

  @DELETE
  @Path("/deleteTrainee/{id}")
  public Trainee deleteTrainee(@PathParam("id") Long id) {
    return null;
  }
}
