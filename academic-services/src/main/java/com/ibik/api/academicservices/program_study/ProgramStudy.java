package com.ibik.api.academicservices.program_study;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="program_study")
public class ProgramStudy implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(length = 50)
  @NotEmpty(message = "Name is required")
  private String name;

  private String description;

  @Column(length = 10, unique = true)
  @NotEmpty(message = "Code is required")
  private String code;

  private int program_id;

  private int faculty_id;

  private int departement_id;

  @Column(columnDefinition = "TINYINT(1)")
    private boolean is_active;

  public ProgramStudy() {
  }

  

  public ProgramStudy(int id, @NotEmpty(message = "Name is required") String name, String description,
      @NotEmpty(message = "Code is required") String code, int program_id, int faculty_id, int departement_id,
      boolean is_active) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.code = code;
    this.program_id = program_id;
    this.faculty_id = faculty_id;
    this.departement_id = departement_id;
    this.is_active = is_active;
  }



  public int getId() {
    return id;
  }



  public void setId(int id) {
    this.id = id;
  }



  public String getName() {
    return name;
  }



  public void setName(String name) {
    this.name = name;
  }



  public String getDescription() {
    return description;
  }



  public void setDescription(String description) {
    this.description = description;
  }



  public String getCode() {
    return code;
  }



  public void setCode(String code) {
    this.code = code;
  }



  public int getProgram_id() {
    return program_id;
  }



  public void setProgram_id(int program_id) {
    this.program_id = program_id;
  }



  public int getFaculty_id() {
    return faculty_id;
  }



  public void setFaculty_id(int faculty_id) {
    this.faculty_id = faculty_id;
  }



  public int getDepartement_id() {
    return departement_id;
  }



  public void setDepartement_id(int departement_id) {
    this.departement_id = departement_id;
  }



  public boolean isIs_active() {
    return is_active;
  }



  public void setIs_active(boolean is_active) {
    this.is_active = is_active;
  }

  
}