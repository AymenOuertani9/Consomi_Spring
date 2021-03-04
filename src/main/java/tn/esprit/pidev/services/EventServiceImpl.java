package tn.esprit.pidev.services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.entities.Advertisement;
import tn.esprit.pidev.entities.CategoryEvent;
import tn.esprit.pidev.entities.Event;
import tn.esprit.pidev.entities.Jackpot;
import tn.esprit.pidev.entities.Participation;
import tn.esprit.pidev.entities.ParticipationPK;
import tn.esprit.pidev.repositories.IAdvertisementRepository;
import tn.esprit.pidev.repositories.IEventRepository;
import tn.esprit.pidev.repositories.IJackpotRepository;
import tn.esprit.pidev.repositories.IParticipationRepository;
@Service
public class EventServiceImpl implements IEventService {
	@Autowired 
	private IEventRepository iEventRepository;
	@Autowired 
	private IAdvertisementRepository iAdvertisementRepository;
	@Autowired 
	private IParticipationRepository iParticipationRepository;
	@Autowired
	private IJackpotRepository iJackpotRepository;
	int number = 1;
	/**********************Creating add method that insert event into database***********************/
	@Override
	public Event addEvent(Event e) {
		 return iEventRepository.save(e) ;
	}
	/*******************Creating deleting method that remove event by id  from database***************/
    @Override
	public void deleteEvent(int id) {
		Event e = iEventRepository.findById(id).get();
		iEventRepository.delete(e);
	}
	/*******************Creating update method that upgrade event from database**********************/
	@Override
	public int updateEvent(Event e, int id) {
        //DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
     
		return iEventRepository.updateEvent(e.getTitle(),e.getDate() , e.getHour(), 
					e.getAddress(), e.getDescription(), e.getNumberOfPlaces(),e.getPriceTicket(),e.getIsStatus(),e.getImage(),e.getIdEvent());
	}
	/**********************Creating getAll method that retrieve all event from database **************/
	@Override
	public List<Event> getAllEvents() {
		List<Event>events = new ArrayList<Event>();
		iEventRepository.findAll().forEach(e ->events.add(e));
		return events;
	}
	/******************Creating getByid method that retrieve event detail from database****************/
	@Override
	public Event getEventById(int id) {
		return iEventRepository.findById(id).get();  
	}
	/**************Creating getByName method that retrieve event detail from database******************/
	@Override
	public Event findEventByName(String name) {
		return iEventRepository.findEventByName(name);
	}
	/**************Creating getByCategoryEvent method that retrieve event detail from database************/
	@Override
	public List<Event> filterEvent(CategoryEvent category) {
		return iEventRepository.filterByCategory(category);
	}
	/**************Creating  affectedEventUser method from database************************************/
	@Override
	public String affecterEventUser(int iduser, int idevent) {
        Event event = iEventRepository.findById(idevent).get();
		int userId = iduser;//user id;
        Participation p = new Participation(); 
		ParticipationPK participationPK = new ParticipationPK(); 
		List<Participation> listParticipations = new ArrayList<Participation>(); 
		listParticipations = (List<Participation>)iParticipationRepository.findAll();
		for(int i = 0; i< listParticipations.size();i++) {
			
			if(listParticipations.get(i).getEvent().getIdEvent() == idevent && 
					listParticipations.get(i).getUser().getIduser() == iduser)
		
				return "You are already participate !!";
			
			else if(listParticipations.get(i).getEvent().getIdEvent()== idevent) { 
				number++;
			}
			else if(listParticipations.get(i).getUser().getIduser() == iduser) {
				number =1;
			}
			
		}
		participationPK.setIdEvent(event.getIdEvent());
		participationPK.setIdUser(userId); 
		participationPK.setNumber(number);
		p.setParticipationPK(participationPK);
        p.setParticipationDate(new Date().toString());
		iParticipationRepository.save(p);
		return "Affected successfully!!";
		
	}
	/**************Creating affectedCategoryEvent method from database************************************/
	@Override
	public String affecterCategoryEvent(String category, int idevent) {
		Event event = iEventRepository.findById(idevent).get();
		String msg=" ";
		
		//bch n7awl men string l enum => CategoryEvent.valueOf(category)
		try {
		for(CategoryEvent c : CategoryEvent.values()) {
			if(c == CategoryEvent.valueOf(category)) {
				event.setCategoryEvent(CategoryEvent.valueOf(category));
				iEventRepository.save(event);
				return msg ="Category Affected successfully!";
			}
		}
	}catch(Exception e) {
			 msg="Failed to affected Category";
		}
		return msg;
		
		
	}
    /****************************BestEventByNumberViews**************************************************/
	@Override 
	public Map<Integer, Integer> getEventsByViews() {
		List<Integer>listId = new ArrayList<>();
		List<Integer>listViews = new ArrayList<>();
		Map<Integer,Integer> h = new HashMap<>();
        for(Event e : iEventRepository.findAll()) {
			listId.add(e.getIdEvent());
			listViews.add(e.getViews());
		}
		List<Integer>sortedList = new ArrayList<>(listViews);
		Collections.sort(sortedList);
		for(int i = 0 ; i <1 ; i++) {
			int max = sortedList.get(sortedList.size()-1);
			int ind = listId.get(listViews.indexOf(max));
			h.put(ind, max);
            System.out.println(ind +" "+ max);
			sortedList.remove(sortedList.size()-1);
			listViews.set(listViews.indexOf(max), -1); 
		}
		return h;
	}
	@Override
	public String affecterEventAdv(int idavert, int idevent) {
		Event event = iEventRepository.findById(idevent).get();
		Advertisement adv= iAdvertisementRepository.findById(idavert).get();
		adv.setEvent(event);
		iAdvertisementRepository.save(adv);
		return "Event affected succesfully to advertisement";
	
	}

	@Override
	public List<Event> upcomingEvents() {
		List<Event> list= iEventRepository.upcomingEvents();
		return list;
	}
	
	/*@Override
	public String affecterEventJackpot(int idjack, int idevent) {
		Event event = iEventRepository.findById(idevent).get();
		Jackpot jack= iJackpotRepository.findById( idjack).get();
		System.out.println("hii="+event+", "+jack);
	
		event.setJackpot(jack);
		iJackpotRepository.save(jack);
		return "Jackpot affected succesfully to event";
	
	}*/
	
	
}
