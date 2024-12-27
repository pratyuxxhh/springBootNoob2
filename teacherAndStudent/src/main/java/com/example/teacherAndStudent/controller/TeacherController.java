package com.example.teacherAndStudent.controller;

import com.example.teacherAndStudent.entities.TeacherPOJO;
import com.example.teacherAndStudent.services.TeacherServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherServices teacherServices;

    @PostMapping("/t")
    public ResponseEntity<TeacherPOJO> postPOJO(@RequestBody TeacherPOJO tpojo){
        System.out.println("Saving entity: " + tpojo);
        teacherServices.saveEntity(tpojo);
        return new ResponseEntity<>(tpojo , HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/t/{id}")
    public ResponseEntity<TeacherPOJO> deletePojo(@PathVariable ObjectId id){
        TeacherPOJO pojo = teacherServices.findById(id).orElse(null);
        teacherServices.deletePojo(pojo);
        return new ResponseEntity<>(pojo , HttpStatus.ACCEPTED);

    }
    @PutMapping("/t/{id}")
    public ResponseEntity<TeacherPOJO> editPOJO(@PathVariable ObjectId id , @RequestBody TeacherPOJO pojo){
        TeacherPOJO OldPojo = teacherServices.findById(id).orElse(null);
            OldPojo.setUserName(pojo.getUserName());
            OldPojo.setPass(pojo.getPass());

        return new ResponseEntity<>(OldPojo , HttpStatus.ACCEPTED);
    }
    @GetMapping("/t")
    public List<TeacherPOJO> getAllUsers(){
        return teacherServices.getAllEntities();
    }
}
