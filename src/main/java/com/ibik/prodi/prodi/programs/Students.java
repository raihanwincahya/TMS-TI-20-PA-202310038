package com.ibik.prodi.prodi.programs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Students implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(length = 15)
  private String npm;

  @Column(length = 10)
  private String firstname;

  @Column(length = 10)
  private String middlename;

  @Column(length = 10)
  private String lastname;

  public Students() {
  }

  public Students(int id, String npm, String firstname, String middlename, String lastname) {
    this.id = id;
    this.npm = npm;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
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

  
}