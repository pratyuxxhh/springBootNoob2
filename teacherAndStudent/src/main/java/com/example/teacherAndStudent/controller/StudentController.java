package com.example.teacherAndStudent.controller;

import com.example.teacherAndStudent.entities.StudentPOJO;
import com.example.teacherAndStudent.services.StudentServices;
import com.example.teacherAndStudent.services.TeacherServices;
import org.apache.catalina.connector.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class StudentController {

    @Autowired
    private TeacherServices teacherServices;
    @Autowired
    private StudentServices studentServices;

    @PostMapping("/{id}")
    public ResponseEntity<?> postStudent(@PathVariable ObjectId id , @RequestBody StudentPOJO pojo){
        studentServices.saveEntry(id , pojo);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}/{DBid}")
    public ResponseEntity<?> deleteEntry (@PathVariable ObjectId id ,@PathVariable ObjectId DBid ){
        studentServices.deleteEntry(id , DBid);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
