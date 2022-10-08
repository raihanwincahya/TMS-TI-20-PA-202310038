package com.ibik.prodi.prodi.programs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/program_study")
public class ProgramController {
  
  // @GetMapping
  // public String helloWorld(){
  //   return "<h1>Hello World</h1>";
  // }

  @Autowired
  private ProgramServices programServices;

  @PostMapping
  public Program_study postPrograms(@RequestBody Program_study program){
    return programServices.save(program);
  }

  @GetMapping
  public Iterable<Program_study> fetchPrograms(){
    return programServices.findAll();
    
  }

  @GetMapping("/{id}")
  public Program_study fetchProgramsById(@PathVariable("id") int id){
    return programServices.findOne(id);
  }

  @PutMapping
  public Program_study updatePrograms(@RequestBody Program_study program){
    return programServices.save(program);
  }

  @DeleteMapping("/{id}")
  public void deleteProgramsById(@PathVariable("id") int id){
    programServices.removeOne(id);
  }

}