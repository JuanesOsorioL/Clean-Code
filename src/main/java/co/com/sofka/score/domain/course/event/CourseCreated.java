package co.com.sofka.score.domain.course.event;

import co.com.sofka.score.domain.generic.DomainEvent;

public class CourseCreated extends DomainEvent {
    private final String courseId;
    private final String name;

    public CourseCreated(String courseId,String name) {
        super("sofka.campus.score.CourseCreated");
        this.courseId = courseId;
        this.name = name;
    }


    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }
}
