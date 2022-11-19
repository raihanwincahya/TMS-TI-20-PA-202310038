package com.ibik.api.academicservices.program_study;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProgramStudyServices{

  @Autowired
  private ProgramStudyRepo programStudyRepo;

  public ProgramStudy save (ProgramStudy programs) {
    return programStudyRepo.save(programs);
    // save() = insert
  }

  public ProgramStudy findOne (int id){
    return programStudyRepo.findById(id).get ();
    // findById() = primarykey
  }

  public Iterable<ProgramStudy> findAll(){
    return programStudyRepo.findAll();
    // findAll() = select
  }

  public void removeOne(int id) {
    programStudyRepo.deleteById(id);
    // deleteById() = delete condition berdasar primarykey
  }
}