package tn.esprit.pidev.services;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import tn.esprit.pidev.entities.CategoryEvent;
import tn.esprit.pidev.entities.Event;
public interface IEventService {
	    public Event addEvent(Event e);
		public void deleteEvent(int id);
		public int updateEvent(Event e , int id);
		public List<Event> getAllEvents();
		public Event getEventById(int id);
		public Event findEventByName(String name);
		public List<Event> filterEvent(CategoryEvent category);
		//public String affecterEventUser(int iduser,int idevent);
		public String affecterCategoryEvent(String category,int idevent);
		public Map<Integer,Integer>getEventsByViews();
		public List<String> displayBestEventsByViews() ;
	    public String affecterEventAdv(int idavert,int idevent);
	    public List<Event> upcomingEvents() ;
	    public void refundUsers(int idevent);
	    public List<String> displayEventsByParticipants();
	    //public String addParticipation(int iduser,int idevent);
	    //public String affecterEventJackpot(int idjack, int idevent);
	    public List<String> displayEventsByCollAmount();
		public Event findbyId(int id);
		public List<String> getEventTwoDatesBeetween(Date date1, Date date2);
		public void reintializeJackPotAfterDateEvent(int idevent);
		
	    public List<Event> passedEvents() ;
	 	    
	    
}
