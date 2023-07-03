package org.example.UniversityEventManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EventService {

    @Autowired
    IEventRepo eventRepo;

    public EventService(IEventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public String addEvent(Event event){
        eventRepo.save(event);
        return "Event added";
    }

    public String updateEvent(Integer Id, Event event){
        Optional<Event>eventOptional = eventRepo.findById(Id);
        if(eventOptional.isPresent()){
            Event event1 = eventOptional.get();
            event1.setEventName(event.getEventName());
            event1.setLocationOfEvent(event.getLocationOfEvent());
            event1.setDate(event.getDate());
            event1.setStartTime(event.getStartTime());
            event1.setEndTime(event.getEndTime());
            eventRepo.save(event1);
            return "event updated";
        }return "Id not found";
    }
    public String deleteEvent(Integer Id){
        Optional<Event>eventOptional = eventRepo.findById(Id);
        if(eventOptional.isPresent()){
            Event event = eventOptional.get();
            eventRepo.delete(event);
            return "event has been removed ";
        }return "Id not found";
    }


    public String getEvent(Integer Id) {
        Optional<Event>eventOptional = eventRepo.findById(Id);
        if(eventOptional.isPresent()){
            Event event = eventOptional.get();
            return event.toString();
        }return "Id not found";
    }
}
