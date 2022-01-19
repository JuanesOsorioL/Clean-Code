package co.com.sofka.score.domain.course.command;

import co.com.sofka.score.domain.generic.Command;

public class AddLesson extends Command {
    private String CourseId;
    private String lessonId;
    private String name;
/*
    public AddLesson(String courseId, String lessonId, String name) {
        this.CourseId = courseId;
        this.lessonId = lessonId;
        this.name = name;
    }*/

    public AddLesson() {
    }

    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
