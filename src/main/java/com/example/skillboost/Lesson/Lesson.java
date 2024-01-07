package com.example.skillboost.Lesson;

public class Lesson {

    private String lessonId;
    private String lessonTitle;
    private String lessonContent;

    // Constructors
    public Lesson() {
    }

    public Lesson(String lessonId, String lessonTitle, String lessonContent) {
        this.lessonId = lessonId;
        this.lessonTitle = lessonTitle;
        this.lessonContent = lessonContent;
    }

    // Getters and Setters
    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getLessonContent() {
        return lessonContent;
    }

    public void setLessonContent(String lessonContent) {
        this.lessonContent = lessonContent;
    }

    // Additional methods or logic can be added based on your requirements
}
