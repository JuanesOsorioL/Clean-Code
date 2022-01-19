package co.com.sofka.score.domain.course.event;

import co.com.sofka.score.domain.generic.DomainEvent;

public class LessonAdded extends DomainEvent {
    private final String lessonId;
    private final String name;

    public LessonAdded(String lessonId, String name) {
        super("sofka.campus.score.LessonAdded");
        this.lessonId = lessonId;
        this.name = name;
    }

    public String getLessonId() {
        return lessonId;
    }

    public String getName() {
        return name;
    }
}
