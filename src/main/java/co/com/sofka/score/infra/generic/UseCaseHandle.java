package co.com.sofka.score.domain.score.infra.generic;

import co.com.sofka.score.domain.generic.DomainEvent;
import co.com.sofka.score.domain.generic.EventStoreRepository;
import co.com.sofka.score.infra.generic.EventSerializer;
import co.com.sofka.score.infra.generic.StoredEvent;
import co.com.sofka.score.infra.message.BusService;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

//@ApplicationScoped
public abstract class UseCaseHandle {

    @Inject
    private EventStoreRepository repository;

    @Inject
    private BusService busService;;

    public void process(String courseId, List<DomainEvent> events) {
        events.stream().map(event -> {
            String eventBody = EventSerializer.instance().serialize(event);
            return new StoredEvent(event.getClass().getTypeName(), new Date(), eventBody);
        }).forEach(storedEvent -> repository.saveEvent("course", courseId, storedEvent));

        events.forEach(busService::send);
    }
}
