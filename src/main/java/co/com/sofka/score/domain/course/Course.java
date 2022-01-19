package co.com.sofka.score.domain.course;

import co.com.sofka.score.domain.course.event.CourseCreated;
import co.com.sofka.score.domain.course.event.LessonAdded;
import co.com.sofka.score.domain.generic.AggregateRoot;
import co.com.sofka.score.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Course extends AggregateRoot {

    protected Map<String,Lesson> lessons;
    protected String name;

    public Course(String id, String name) {
        super(id);
        Objects.requireNonNull(name);
        subscribe(new CourseEventChange(this));
        appendChange(new CourseCreated(id,name)).apply();
    }

    private Course(String id) {
        super(id);
        subscribe(new CourseEventChange(this));
    }

    public static Course from (String courseId, List<DomainEvent> events){
        var course=new Course(courseId);
        events.forEach(course::applyEvent);
        return course;
    }

    public void addLessons(String id,String name) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        appendChange(new LessonAdded(id,name)).apply();
    }



    public void addStudentToLessonOf(String lessonId,String name, String email) {
        this.lessons.get(lessonId).addStudent(name,email);
    }


    public void evaluationStudent(String lessonId,String name, Score score){
        this.lessons.get(lessonId).evaluationStudent(name,score);
    }

    public Lesson findLessonById(String id){
        return lessons.get(id);
    }

}
