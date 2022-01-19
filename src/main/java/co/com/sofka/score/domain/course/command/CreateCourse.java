package co.com.sofka.score.domain.course.command;

import co.com.sofka.score.domain.generic.Command;

public class CreateCourse extends Command {
    private String courseId;
    private String name;

/*    public CreateCourse(String courseId, String name) {
        this.courseId = courseId;
        this.name = name;
    }*/

    public CreateCourse() {
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }
}
