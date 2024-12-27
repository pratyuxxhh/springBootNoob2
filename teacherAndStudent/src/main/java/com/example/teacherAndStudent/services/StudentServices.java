package com.example.teacherAndStudent.services;

import com.example.teacherAndStudent.entities.StudentPOJO;
import com.example.teacherAndStudent.entities.TeacherPOJO;
import com.example.teacherAndStudent.repositories.StudentRepo;
import com.example.teacherAndStudent.repositories.TeacherRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentServices {
    @Autowired
    private TeacherServices teacherServices;
    @Autowired
    private StudentRepo studentRepo;

    public void saveEntry(ObjectId id, StudentPOJO pojo) {
        saveEntryInDB(pojo);
        Optional<TeacherPOJO> tpojo = teacherServices.findById(id);
        if (tpojo.isPresent()){
            tpojo.get().getStudentList().add(pojo);
            teacherServices.saveEntity(tpojo.get());
        }

    }
    public void saveEntryInDB(StudentPOJO pojo){
        studentRepo.save(pojo);
    }

    public void deleteEntry(ObjectId id, ObjectId dBid) {
        Optional<TeacherPOJO> tpojo = teacherServices.findById(id);
        Optional<StudentPOJO> spojo = studentRepo.findById(dBid);
        if(tpojo.isPresent()){
            if(spojo.isPresent()) studentRepo.delete(spojo.get());

            teacherServices.saveEntity(tpojo.get());
        }

    }
}
