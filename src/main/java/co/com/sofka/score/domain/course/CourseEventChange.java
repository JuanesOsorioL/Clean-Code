package co.com.sofka.score.domain.course;

import co.com.sofka.score.domain.course.event.LessonAdded;
import co.com.sofka.score.domain.course.event.CourseCreated;
import co.com.sofka.score.domain.generic.EventChange;

import java.util.HashMap;

public class CourseEventChange implements EventChange {

    public CourseEventChange(Course course){

        listener((CourseCreated event)->{
            course.name= event.getName();
            course.lessons=new HashMap<>();
        });

        listener((LessonAdded event)->{
            course.lessons.put(event.getLessonId(),new Lesson(event.getLessonId(),event.getName()));
        });

    }
}
