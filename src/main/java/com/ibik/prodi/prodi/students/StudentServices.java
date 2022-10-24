package com.ibik.prodi.prodi.students;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class StudentServices {

    @Autowired
  private StudentRepo studentRepo;

  public Students save(Students students){
    return studentRepo.save(students);
  }

  public Students findOne(int id){
    return studentRepo.findById(id).get();
  }

  public Iterable<Students> findAll(){
    return studentRepo.findAll();
  }

  public void removeOne(int id){
    studentRepo.deleteById(id);
  }

}
