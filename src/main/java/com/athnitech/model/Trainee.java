package com.athnitech.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainee {

  public long id;
  public String fullName;
  public String email;
  public String phoneNumber;
  public long yearsOfExperience;
  public List<String> coursesEnrolled;
}
