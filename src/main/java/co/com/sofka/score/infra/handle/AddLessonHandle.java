package co.com.sofka.score.infra.handle;
import co.com.sofka.score.domain.course.command.AddLesson;
import co.com.sofka.score.domain.score.infra.generic.UseCaseHandle;
import co.com.sofka.score.usecase.AddLessoUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddLessonHandle extends UseCaseHandle {

    private final AddLessoUseCase useCase;

    public AddLessonHandle(AddLessoUseCase useCase) {
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofka.course.addlesson")
    void consumeBlocking(AddLesson command) {
        var events = useCase.apply(command);
        process(command.getCourseId(), events);
    }


}
