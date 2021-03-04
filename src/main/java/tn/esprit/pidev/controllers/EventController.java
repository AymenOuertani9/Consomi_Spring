package tn.esprit.pidev.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.pidev.entities.CategoryEvent;
import tn.esprit.pidev.entities.Event;
import tn.esprit.pidev.services.IEventService;

@RestController
public class EventController {

	@Autowired  
	private IEventService iEventService; 
	
	//creating post mapping that post the event detail in the database  
		@PostMapping("/event/add-event")  
		private int addEvent(@RequestBody Event event)   
		{  
			iEventService.addEvent(event);  
			return event.getIdEvent();  
		}
	
	//creating a delete mapping that deletes a specified event  
		@DeleteMapping("/event/delete-event/{eventid}")  
		private void deleteEvent(@PathVariable("eventid") int eventid)   
		{  
			iEventService.deleteEvent(eventid);  
		}
		
	//creating put mapping that updates the event detail   
		@PutMapping("/event/update-event/{eventid}")  
		private Event updateEvent(@RequestBody Event events, @PathVariable("eventid")int eventId)   
		{  
			iEventService.updateEvent(events,eventId);  
			return events;  
		}
		
	//creating a get mapping that retrieves all the event detail from the database   
		@GetMapping("/event/get-all-events")  
		private List<Event> getAllEvents()   
		{  
			return iEventService.getAllEvents();  
		} 
		
	//creating a get mapping that retrieves the detail of a specific event  
		@GetMapping("/event/detail-event/{eventid}")  
		private Event getEvent(@PathVariable("eventid") int eventid)   
		{  
			return iEventService.getEventById(eventid);  
		} 
		
	//creating get mapping that getEventByName   
        @GetMapping("/retrieve-Event-ByName/{name}")
		public Event getEventByName(@PathVariable String name) {
			 Event event = iEventService.findEventByName(name);
			return event;
			}
        
     //creating get mapping that getEventByCategory
        @GetMapping("/retrieve-Event-ByCategory/{category}")
    	public List<Event> getEventByCategory(@PathVariable CategoryEvent category) {
    		List<Event> event = iEventService.filterEvent(category);
    		return event;
    		}
      
    	//creating put mapping that affected participant event 
		@PutMapping("/event/affecter-participant-event/{iduser}/{idevent}")  
		private String affecterEventUser(@PathVariable("iduser")int iduser,@PathVariable("idevent")int idevent)   
		{  
		   return iEventService.affecterEventUser(iduser, idevent);
			
		}
		
		//creating put mapping that affectedCategoryEvent  
		@PutMapping("/event/affecter-category-event/{category}/{idevent}")  
				private String affecterCategoryEvent(@PathVariable("category")String category,@PathVariable("idevent")int idevent)   
		{  
				
					return iEventService.affecterCategoryEvent(category, idevent);
					
		}
		//display event By views
		@GetMapping("/event/displaybestEventsByViews")
		public Map<Integer,Integer> displaybestEventsByViews(){
			return iEventService.getEventsByViews();
			}
		//affected advertisement  
		@PutMapping("/event/affected-advertisement-event/{idevent}/{idavert}")
		@ResponseBody
			public String affectEventAdver(@PathVariable("idevent")int idevent, @PathVariable("idavert")int idavert) {
			iEventService.affecterEventAdv(idavert, idevent);
			return "Event affected to advertisement successfully!!";
		}
		//displayEventevents-after-today-date
		@GetMapping("/event/displayEventevents-after-today-date")
		public List<Event> upcomingEvents() {
			List<Event>upevents = iEventService.upcomingEvents();
			return upevents;
		}
		//affected Jackpot  
		//@PutMapping("/event/affected-jackpot-event/{idevent}/{idjack}")
		//@ResponseBody
			/*public String affectEventJackpot(@PathVariable("idevent")int idevent, @PathVariable("idjack")int idjack) {
			
			return iEventService.affecterEventJackpot(idjack, idevent);
		}*/
		
		
}
