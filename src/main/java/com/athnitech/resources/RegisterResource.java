package com.athnitech.resources;

import com.athnitech.model.Trainee;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.springframework.stereotype.Component;

@Component
@Path("/api")
public class RegisterResource {

  @POST
  @Path("register/trainee")
  public void registerUser(Trainee trainee) {

  }
}
