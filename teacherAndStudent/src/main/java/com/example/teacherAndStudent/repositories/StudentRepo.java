package com.example.teacherAndStudent.repositories;

import com.example.teacherAndStudent.entities.StudentPOJO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepo extends MongoRepository<StudentPOJO, ObjectId> {

}
