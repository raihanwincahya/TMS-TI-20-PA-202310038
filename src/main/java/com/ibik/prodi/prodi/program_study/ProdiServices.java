package com.ibik.prodi.prodi.program_study;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class ProdiServices {
    
    @Autowired
  private ProdiRepo prodiRepo;

  public Program_study save(Program_study program_study){
    return prodiRepo.save(program_study);
  }

  public Program_study findOne(int id){
    return prodiRepo.findById(id).get();
  }

  public Iterable<Program_study> findAll(){
    return prodiRepo.findAll();
  }

  public void removeOne(int id){
    prodiRepo.deleteById(id);
  }

}
