package com.example.skillboost.Lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public Lesson addLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public List<Lesson> findAllLessons() {
        return lessonRepository.findAll();
    }

    public Lesson getLessonById(String lessonId) {
        return lessonRepository.findById(lessonId).orElse(null);
    }

    public void deleteLessonById(String lessonId) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        lessonOptional.ifPresent(lessonRepository::delete);
        // Additional logic if needed
    }

    public Lesson updateLesson(String lessonId, Lesson updatedLesson) {
        Optional<Lesson> existingLessonOptional = lessonRepository.findById(lessonId);
        if (existingLessonOptional.isPresent()) {
            Lesson existingLesson = existingLessonOptional.get();
            // Update necessary fields using setters
            existingLesson.setLessonTitle(updatedLesson.getLessonTitle());
            existingLesson.setLessonContent(updatedLesson.getLessonContent());

            return lessonRepository.save(existingLesson);
        } else {
            // Handle the case when the lesson with the specified ID does not exist.
            // You can throw an exception, log a message, or take any other appropriate action.
            return null;
        }
    }
}
