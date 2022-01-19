package co.com.sofka.score.usecase;

import co.com.sofka.score.domain.course.Course;
import co.com.sofka.score.domain.course.command.CreateCourse;
import co.com.sofka.score.domain.generic.DomainEvent;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class CreateCourseUseCase implements Function<CreateCourse, List<DomainEvent>> {

    @Override
    public List<DomainEvent> apply(CreateCourse command) {
        var course = new Course(command.getCourseId(),command.getName());
        return course.getUncommittedChanges();
    }
}
