package com.ibik.prodi.prodi.courses;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.persistence.GenerationType;
import com.ibik.prodi.prodi.students.Students;

@Entity
@Table(name="courses")
public class Courses implements Serializable {
    
    private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(length = 50)
  @NotEmpty(message = "Name is required")
  private String name;

  @Column(length = 10)
  @NotEmpty(message = "Code is required")
  private String code;

  @Column(length = 5)
  @Min(value = 1, message = "credit is required")
  private int credit;

  @Column(columnDefinition = "TINYINT(1)")
  private boolean is_active;

  @ManyToMany(mappedBy = "courses")
  private Set<Students> students;

    public Courses() {
    }

    public Courses(int id, @NotEmpty(message = "Name is required") String name,
            @NotEmpty(message = "Code is required") String code,
            @Min(value = 11, message = "credit is required") int credit, boolean is_active) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.credit = credit;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
  
    public Set<Students> getStudents() {
        return students;
    }

    public void setStudents(Set<Students> students) {
        this.students = students;
    }
}
