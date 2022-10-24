package com.ibik.prodi.prodi.program_study;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.ibik.prodi.prodi.programs.Programs;

@Entity
@Table(name="program_study")
public class Program_study implements Serializable {

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

  // private int program_id;
  @ManyToOne
  @JoinColumn(name = "program_id")
  private Programs programs;

  // private int faculty_id;
  @OneToMany
  @JoinColumn(name = "faculty_id")
  private Set<Program_study>departments;

  private int departement_id;

  @Column(columnDefinition = "TINYINT(1)")
    private boolean is_active;

  

  public Program_study(int id, @NotEmpty(message = "Name is required") String name, String description,
      @NotEmpty(message = "Code is required") String code, Programs programs, Set<Program_study> departments,
      int departement_id, boolean is_active) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.code = code;
    this.programs = programs;
    this.departments = departments;
    this.departement_id = departement_id;
    this.is_active = is_active;
  }

  public Program_study() {
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
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

  public Programs getPrograms() {
    return programs;
  }

  public void setPrograms(Programs programs) {
    this.programs = programs;
  }

  public Set<Program_study> getDepartments() {
    return departments;
  }

  public void setDepartments(Set<Program_study> departments) {
    this.departments = departments;
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