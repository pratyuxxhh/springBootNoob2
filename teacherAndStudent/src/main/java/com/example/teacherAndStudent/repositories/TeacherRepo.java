package com.example.teacherAndStudent.repositories;

import com.example.teacherAndStudent.entities.TeacherPOJO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface TeacherRepo extends MongoRepository<TeacherPOJO , ObjectId> {

    Optional<TeacherPOJO> findById(ObjectId id);
}
