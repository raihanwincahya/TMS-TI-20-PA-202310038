package com.ibik.api.academicservices.programs;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.Errors;
import com.ibik.api.academicservices.dto.ResponseData;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.ObjectError;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/programs")
public class ProgramController {
    
    @Autowired
    private ProgramServices programServices;

    @PostMapping
    public ResponseEntity<ResponseData<Program>> postPrograms(@Valid @RequestBody Program programs, Errors errors) {
        ResponseData<Program> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setResult(false);
            responseData.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setResult(true);
        List<Program> value = new ArrayList<>();
        value.add(programServices.save(programs));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    // public ResponseEntity<ResponseData<Students>> fetchStudent() {
    public ResponseEntity<ResponseData<Program>> fetchPrograms() {
        ResponseData<Program> responseData = new ResponseData<>();
        try {
            Iterable<Program> values = programServices.findAll();
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
    public ResponseEntity<ResponseData<Program>> fetchProgramsById(@PathVariable("id") int id) {
        ResponseData<Program> responseData = new ResponseData<>();
        try {
            Program values = programServices.findOne(id);
            List<Program> result = new ArrayList<>();
            result.add(values);
            responseData.setResult(true);
            responseData.setMessage(null);
            responseData.setData(result);
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
    public ResponseEntity<ResponseData<Program>> updatePrograms(@Valid @RequestBody Program programs, Errors errors) {

        ResponseData<Program> responseData = new ResponseData<>();

        if (programs.getId() != 0) {
            if (errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    responseData.getMessage().add(error.getDefaultMessage());
                }
                responseData.setResult(false);
                responseData.setData(null);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }

            responseData.setResult(true);
            List<Program> value = new ArrayList<>();
            value.add(programServices.save(programs));
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
    public ResponseEntity<ResponseData<Program>> deleteProgramById(@PathVariable("id") int id) {
        ResponseData<Program> responseData = new ResponseData<>();
        if (id != 0) {
            try {
                programServices.removeOne(id);
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
        } else {
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

    }

}