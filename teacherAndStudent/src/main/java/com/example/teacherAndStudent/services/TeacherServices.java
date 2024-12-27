package com.example.teacherAndStudent.services;


import com.example.teacherAndStudent.entities.TeacherPOJO;
import com.example.teacherAndStudent.repositories.TeacherRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TeacherServices {

    @Autowired
    private TeacherRepo teacherrepo;

    public void saveEntity(TeacherPOJO tpojo){

        teacherrepo.save(tpojo);
        System.out.println("Saved entity: " + tpojo);

    }

    public List<TeacherPOJO> getAllEntities() {
        List<TeacherPOJO> list = teacherrepo.findAll();
        return  list;

    }

    public void deletePojo(TeacherPOJO pojo) {
        teacherrepo.delete(pojo);
    }

    public Optional<TeacherPOJO> findById(ObjectId id ){
        return teacherrepo.findById(id);
    }
}
