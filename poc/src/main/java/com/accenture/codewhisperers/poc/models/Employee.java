package com.accenture.codewhisperers.poc.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employees")
public class Employee {
  @Id
  private String id;
  private String eid;
  private String first_name;
  private String second_name;
  private String id_number;

  public Employee(String id, String eid, String first_name, String second_name, String id_number) {
    this.id = id;
    this.eid = eid;
    this.first_name = first_name;
    this.second_name = second_name;
    this.id_number = id_number;
  }

  public void setId_number(String id_number) {
    this.id_number = id_number;
  }

  public String getId_number() {
    return id_number;
  }

  public void setEid(String eid) {
    this.eid = eid;
  }

  public String getEid() {
    return this.eid;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return this.id;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getFirst_name() {
    return this.first_name;
  }

  public void setSecond_name(String second_name) {
    this.second_name = second_name;
  }

  public String getSecond_name() {
    return this.second_name;
  }
}
