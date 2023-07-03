package org.example.UniversityEventManagement;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventController {
    @Autowired
    EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
@PostMapping("event")
    public String addEvent(@Valid @RequestBody Event event){
        return eventService.addEvent(event);
    }
@PutMapping("event/Id/{Id}")
    public String updateEvent(@PathVariable Integer Id,@Valid @RequestBody Event event){
        return eventService.updateEvent(Id,event);
    }
@DeleteMapping("event/{Id}")
    public String deleteEvent(@PathVariable Integer Id){
        return eventService.deleteEvent(Id);
    }
    @GetMapping("event/Id/{Id}")
        public String getEvent(@PathVariable Integer Id){
        return  eventService.getEvent(Id);
        }
    }

