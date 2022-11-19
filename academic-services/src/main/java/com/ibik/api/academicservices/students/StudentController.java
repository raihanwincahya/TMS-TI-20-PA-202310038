package com.ibik.api.academicservices.students;

import org.springframework.web.bind.annotation.RestController;

import com.ibik.api.academicservices.dto.*;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @PostMapping()
    public ResponseEntity<ResponseData<Student>> postStudent(@Valid @RequestBody Student students, Errors errors) {
        
        ResponseData<Student> responseData = new ResponseData<>();

        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setResult(false);
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

        }
        
        responseData.setResult(true);
        List<Student> value = new ArrayList<>();
        value.add(studentServices.save(students));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    // public Iterable<Students> fetchStudent(){
    public ResponseEntity<ResponseData<Student>> fetchStudent() {
        // return studentsServices.findAll();
        ResponseData<Student> responseData = new ResponseData<>();
        try {
            Iterable<Student> values = studentServices.findAll();
            responseData.setResult(true);
            responseData.setMessage(null);
            responseData.setData(values);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @GetMapping("/{id}")
    // public Students fetchStudentById(@PathVariable("id") int id){
    public ResponseEntity<ResponseData<Student>> fetchStudentById(@PathVariable("id") int id) {
        // return studentsServices.findOne(id);
        ResponseData<Student> responseData = new ResponseData<>();

        try {
            Student values = studentServices.findOne(id);
            List<Student> result = new ArrayList<>();
            result.add(values);
            responseData.setData(result);
            responseData.setResult(true);
            responseData.setMessage(null);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @PutMapping
    // public Students updateStudent(@RequestBody Students students){
    public ResponseEntity<ResponseData<Student>> updateStudent(@Valid @RequestBody Student students, Errors errors) {
        ResponseData<Student> responseData = new ResponseData<>();

        if (students.getId() != 0) {

            if (errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    responseData.getMessage().add(error.getDefaultMessage());
                }
                responseData.setResult(false);
                responseData.setData(null);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }

            responseData.setResult(true);
            List<Student> value = new ArrayList<>();
            value.add(studentServices.save(students));
            responseData.setData(value);
            return ResponseEntity.ok(responseData);

        } else {
            responseData.setResult(false);
            responseData.setData(null);
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @DeleteMapping("/{id}")
    //public void deleteStudentById(@PathVariable("id") int id){
    public ResponseEntity<ResponseData<Student>> deleteStudentById(@PathVariable("id") int id){    
        ResponseData<Student> responseData = new ResponseData<>();
        if(id != 0){
            try {
                studentServices.removeOne(id);
                List<String> message = new ArrayList<>();
                message.add("Successfully removed");
                responseData.setMessage(message);
                responseData.setData(null);
                responseData.setResult(true);
                return ResponseEntity.ok(responseData);
            } catch (Exception e) {
                List<String> message = new ArrayList<>();
                message.add(e.getMessage());
                responseData.setMessage(message);
                responseData.setData(null);
                responseData.setResult(false);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }
        }else{
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        
    }

    @PostMapping("/search") 
    public ResponseEntity<ResponseData<Student>> getStudentByName(@RequestBody SearchData SearchData) { 
        ResponseData<Student> responseData = new ResponseData<>(); 
 
        try { 
            Iterable<Student> values = studentServices.findByName(SearchData.getSearchKey()); 
            responseData.setResult(true); 
            responseData.getMessage(); 
            responseData.setData(values); 
            return ResponseEntity.ok(responseData); 
        } catch (Exception ex) { 
            responseData.getMessage().add(ex.getMessage()); 
            responseData.setData(null); 
            responseData.setResult(false); 
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData); 
        } 
    }
}