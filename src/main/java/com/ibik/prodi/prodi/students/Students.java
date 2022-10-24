package com.ibik.prodi.prodi.students;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.ibik.prodi.prodi.courses.Courses;
import com.ibik.prodi.prodi.program_study.Program_study;
import com.ibik.prodi.prodi.programs.Programs;

@Entity
@Table(name="students")
public class Students implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(length = 15, unique = true)
  @NotEmpty(message = "NPM is required")
  private String npm;

  @Column(length = 10)
  @NotEmpty(message = "firstname is required")
  private String firstname;

  @Column(length = 10)
  private String middlename;

  @Column(length = 10)
  @NotEmpty(message = "lastname is required")
  private String lastname;

  @Min(value = 1, message = "program is required")
  private int program_id;
  // @ManyToOne
  // @JoinColumn(name = "program_id")
  // private Programs programs;

  @Min(value = 1, message = "Department is required")
  private int department_id;
  // @ManyToOne
  // @JoinColumn(name = "program_study_id")
  // private Set<Program_study> program_study;

  // @ManyToMany
  // @JoinTable(
  //   name = "student_rel_courses",
  //   joinColumns = @JoinColumn(name = "student_id"),
  //   inverseJoinColumns = @JoinColumn(name = "course_id")
  // )
  // private Set<Courses> courses;

  public Students() {
  }

  public Students(int id, @NotEmpty(message = "NPM is required") String npm,
      @NotEmpty(message = "firstname is required") String firstname, String middlename,
      @NotEmpty(message = "lastname is required") String lastname,
      @Min(value = 1, message = "program is required") int program_id,
      @Min(value = 1, message = "Department is required") int department_id) {
    this.id = id;
    this.npm = npm;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.program_id = program_id;
    this.department_id = department_id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNpm() {
    return npm;
  }

  public void setNpm(String npm) {
    this.npm = npm;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public void setMiddlename(String middlename) {
    this.middlename = middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public int getProgram_id() {
    return program_id;
  }

  public void setProgram_id(int program_id) {
    this.program_id = program_id;
  }

  public int getDepartment_id() {
    return department_id;
  }

  public void setDepartment_id(int department_id) {
    this.department_id = department_id;
  }



}