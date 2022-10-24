package com.ibik.prodi.prodi.programs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProgramServices {
  
  @Autowired
  private ProgramRepo programRepo;

  public Programs save(Programs program){
    return programRepo.save(program);
  }

  public Programs findOne(int id){
    return programRepo.findById(id).get();
  }

  public Iterable<Programs> findAll(){
    return programRepo.findAll();
  }

  public void removeOne(int id){
    programRepo.deleteById(id);
  }

}