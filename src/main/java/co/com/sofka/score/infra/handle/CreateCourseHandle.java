package co.com.sofka.score.infra.handle;

import co.com.sofka.score.domain.course.command.CreateCourse;
import co.com.sofka.score.domain.score.infra.generic.UseCaseHandle;
import co.com.sofka.score.usecase.CreateCourseUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateCourseHandle extends  UseCaseHandle{

    private final CreateCourseUseCase useCase;

    public CreateCourseHandle(CreateCourseUseCase useCase) {
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofka.course.create")
    void consumeBlocking(CreateCourse command) {
        var events = useCase.apply(command);
        process(command.getCourseId(), events);
    }
}
